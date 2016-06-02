package com.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import junit.framework.TestCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import javax.servlet.Filter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloApplication.class)
@WebAppConfiguration
public class HelloApplicationTests extends TestCase{

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private Filter springSecurityFilterChain;

	MockMvc mvc;

	@Before
	public void setUp() {
		mvc = webAppContextSetup(context)
				.addFilter(springSecurityFilterChain)
				.build();
	}

	@Test
	public void testUnauthenticatedAccess() throws Exception {
		mvc.perform(get("/hello")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testSignUp() throws Exception {
		mvc.perform(post("/registration").param("username", "user").param("password", "pass")).andExpect(status().is3xxRedirection());
	}

	@Test
	public void testLogIn() throws Exception {
		mvc.perform(post("/login").param("username", "user").param("password", "pass")).andExpect(status().is3xxRedirection());
	}
}
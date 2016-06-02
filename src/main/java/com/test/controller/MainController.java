package com.test.controller;

import com.test.dto.User;
import com.test.service.UserService;
import com.test.util.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mrmas on 31.05.2016.
 */

@RequestMapping(value = "/")
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request, HttpServletResponse response) {

        User user = new User();

        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        if (name.isEmpty() || pass.isEmpty()) {
            return "Fill all data";
        }

        user.setName(name);
        user.setPass(pass);

        userService.save(user);

        return "redirect: /hello";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public int validate(@RequestBody String pass) {
        return PasswordValidator.checkPasswordStrength(pass);
    }

}

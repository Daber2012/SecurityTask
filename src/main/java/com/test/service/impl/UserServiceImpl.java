package com.test.service.impl;

import com.test.dto.User;
import com.test.repository.UserRepository;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by mrmas on 01.06.2016.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String name) {
        return userRepository.findByName(name);
    }
}

package com.test.service;

import com.test.dto.User;

/**
 * Created by mrmas on 01.06.2016.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String user);
}

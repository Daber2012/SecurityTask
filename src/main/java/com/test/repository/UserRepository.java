package com.test.repository;

import com.test.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mrmas on 01.06.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}

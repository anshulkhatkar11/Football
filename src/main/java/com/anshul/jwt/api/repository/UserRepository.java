package com.anshul.jwt.api.repository;

import com.anshul.jwt.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);

    Optional<User> findByUserNameAndPassword(String username, String password);
}

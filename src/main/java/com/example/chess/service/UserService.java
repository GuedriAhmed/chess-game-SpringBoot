package com.example.chess.service;

import com.example.chess.model.User;

import java.util.Optional;

public interface UserService {
    User register(User user);
    Optional<User> findByUsername(String username);

}

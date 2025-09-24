package com.example.chess.service.implimentation;

import com.example.chess.model.User;
import com.example.chess.repo.UserRepo;
import com.example.chess.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImp implements UserService {

    private final UserRepo repo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        log.info("UserServiceImp registering user {}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        log.info("UserServiceImp finding user {}", username);
        return repo.findByUsername(username);
    }


}

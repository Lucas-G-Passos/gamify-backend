package com.gamify.gym.api.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamify.gym.api.user.model.User;
import com.gamify.gym.api.user.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(String username, String email, String password) {
        User user = new User();
        String hashed = encoder.encode(password);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(hashed);
        return userRepository.save(user);
    }
}

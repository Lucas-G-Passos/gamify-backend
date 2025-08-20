package com.gamify.gym.api.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gamify.gym.api.user.service.AuthService;
import com.gamify.gym.api.user.service.UserService;
import com.gamify.gym.api.user.dto.UserCreationRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class Login {
    private final AuthService authService;
    private final UserService userService;

    public Login(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping(value = "/user/create", consumes = "application/json")
    public ResponseEntity<?> createUser(@RequestBody UserCreationRequest request) {
        try {
            var user = userService.createUser(request.getUsername(), request.getEmail(), request.getPassword());
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        return authService.authenticate(authentication);
    }

    @GetMapping("/check")
    public String check() {
        return "Valid";
    }
}

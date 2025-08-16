package com.gamify.gym.api.user.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gamify.gym.api.user.service.AuthService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class Login {
    private final AuthService authService;

    public Login(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        return authService.authenticate(authentication);
    }

}

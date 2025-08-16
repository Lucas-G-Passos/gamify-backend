package com.gamify.gym.api.user.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Profile {
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@AuthenticationPrincipal Jwt jwt) {
        String userType = jwt.getClaim("userType");
        String username = jwt.getSubject();

        return ResponseEntity.ok(Map.of(
                "username", username,
                "userType", userType));
    }
}

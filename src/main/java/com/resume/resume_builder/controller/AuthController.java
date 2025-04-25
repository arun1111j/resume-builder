package com.resume.resume_builder.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    
    @GetMapping("/home")
    public Map<String, String> home(@AuthenticationPrincipal OAuth2User principal) {
        return Map.of(
            "message", "Welcome to the home page",
            "user", principal != null ? principal.getName() : "anonymous"
        );
    }
    
    @GetMapping("/login")
    public Map<String, String> login() {
        return Map.of(
            "message", "Please authenticate",
            "oauthUrl", "/oauth2/authorization/google"
        );
    }
}
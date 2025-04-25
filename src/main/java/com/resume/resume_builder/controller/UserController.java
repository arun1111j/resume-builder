package com.resume.resume_builder.controller;

import com.resume.resume_builder.util.AuthUtils;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> response = new HashMap<>();
        if (principal != null) {
            response.put("name", principal.getAttribute("name"));
            response.put("email", principal.getAttribute("email"));
            response.put("isAdmin", AuthUtils.isAdmin());
        }
        return response;
    }

    @GetMapping("/user-info")
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        return principal != null ? principal.getAttributes() : Map.of();
    }
}
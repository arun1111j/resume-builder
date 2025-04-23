package com.resume.resume_builder.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    
    @GetMapping("/home")
    public String home(Principal principal) {
        return "home"; // Your secured landing page
    }
    
    @GetMapping("/login")
    public String login() {
        return "login"; // Your custom login page
    }
}

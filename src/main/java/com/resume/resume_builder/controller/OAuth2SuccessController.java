package com.resume.resume_builder.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OAuth2SuccessController {
    
    @Value("${client.url}")
    private String clientUrl;
    
    @GetMapping("/oauth2/success")
    public RedirectView oauthSuccess(@AuthenticationPrincipal OAuth2User principal) {
        // You can add additional logic here if needed
        return new RedirectView(clientUrl + "/home");
    }
    
    @GetMapping("/oauth2/failure")
    public RedirectView oauthFailure() {
        return new RedirectView(clientUrl + "/login?error=authentication_failed");
    }
}
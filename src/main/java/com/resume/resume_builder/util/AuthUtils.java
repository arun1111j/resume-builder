package com.resume.resume_builder.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.access.AccessDeniedException;

public class AuthUtils {

    public static String getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof OAuth2User) {
            return ((OAuth2User) authentication.getPrincipal()).getName();
        }
        throw new AccessDeniedException("User not authenticated");
    }

    public static String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof OAuth2User) {
            OAuth2User user = (OAuth2User) authentication.getPrincipal();
            
            // Check possible email attributes in order
            String email = getAttribute(user, "email");
            if (email != null) return email;
            
            email = getAttribute(user, "mail");
            if (email != null) return email;
            
            email = getAttribute(user, "upn");
            if (email != null) return email;
            
            email = getAttribute(user, "preferred_username");
            if (email != null) return email;
            
            throw new AccessDeniedException("Email not available");
        }
        throw new AccessDeniedException("User not authenticated");
    }

    private static String getAttribute(OAuth2User user, String attributeName) {
        Object attribute = user.getAttribute(attributeName);
        return attribute != null ? attribute.toString() : null;
    }

    public static boolean isAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            for (var authority : authentication.getAuthorities()) {
                if ("ROLE_ADMIN".equals(authority.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }
}
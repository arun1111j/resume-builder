package com.resume.resume_builder.service.impl;

import com.resume.resume_builder.model.User;
import com.resume.resume_builder.repository.UserRepository;
import com.resume.resume_builder.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserRole(String userId, String newRole) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Replace all existing roles with the new one
        Set<String> roles = new HashSet<>();
        roles.add(newRole);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}

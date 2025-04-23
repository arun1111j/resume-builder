package com.resume.resume_builder.service;

import com.resume.resume_builder.model.User;
import java.util.List;

public interface AdminService {
    List<User> getAllUsers();
    User updateUserRole(String userId, String newRole);
    void deleteUser(String userId);
}
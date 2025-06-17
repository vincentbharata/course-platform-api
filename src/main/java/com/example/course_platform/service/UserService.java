package com.example.course_platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_platform.dto.AuthDto.*;
import com.example.course_platform.dto.AuthDto.AuthRequest;
import com.example.course_platform.dto.AuthDto.AuthResponse;
import com.example.course_platform.model.User;
import com.example.course_platform.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public AuthResponse register(AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // Note: hash this in real apps
        user.setRole("STUDENT");
        userRepo.save(user);
        return new AuthResponse("dummy-jwt-token");
    }

    public AuthResponse login(AuthRequest request) {
        return new AuthResponse("dummy-jwt-token");
    }
}

package com.example.course_platform.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.course_platform.dto.EnrollmentResponse;
import com.example.course_platform.model.User;
import com.example.course_platform.repository.UserRepository;
import com.example.course_platform.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired private EnrollmentService enrollmentService;

    @Autowired private UserRepository userRepository;

    @PostMapping
    public void enroll(@RequestParam Long courseId, Principal principal) {
        User student = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        enrollmentService.enroll(student, courseId);
    }

    @GetMapping("/my")
    public List<EnrollmentResponse> getMyCourses(Principal principal) {
        User student = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return enrollmentService.getUserEnrollments(student);
    }
}

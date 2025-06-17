package com.example.course_platform.controller;

import com.example.course_platform.dto.EnrollmentResponse;
import com.example.course_platform.model.User;
import com.example.course_platform.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired private EnrollmentService enrollmentService;

    @PostMapping
    public void enroll(@RequestParam Long courseId, Principal principal) {
        User student = new User(); // Dummy fetch by principal
        student.setUsername(principal.getName());
        enrollmentService.enroll(student, courseId);
    }

    @GetMapping("/my")
    public List<EnrollmentResponse> getMyCourses(Principal principal) {
        User student = new User(); // Dummy fetch
        student.setUsername(principal.getName());
        return enrollmentService.getUserEnrollments(student);
    }
}

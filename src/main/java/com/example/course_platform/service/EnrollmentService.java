package com.example.course_platform.service;

import com.example.course_platform.dto.EnrollmentResponse;
import com.example.course_platform.model.Course;
import com.example.course_platform.model.Enrollment;
import com.example.course_platform.model.User;
import com.example.course_platform.repository.CourseRepository;
import com.example.course_platform.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    @Autowired private EnrollmentRepository enrollmentRepo;
    @Autowired private CourseRepository courseRepo;

    public void enroll(User user, Long courseId) {
        Course course = courseRepo.findById(courseId).orElseThrow();
        Enrollment e = new Enrollment();
        e.setUser(user);
        e.setCourse(course);
        e.setEnrolledDate(LocalDateTime.now());
        enrollmentRepo.save(e);
    }

    public List<EnrollmentResponse> getUserEnrollments(User user) {
        return enrollmentRepo.findByUser(user).stream()
                .map(e -> new EnrollmentResponse(e.getId(), e.getCourse().getTitle(), e.getEnrolledDate()))
                .collect(Collectors.toList());
    }
}

package com.example.course_platform.controller;

import com.example.course_platform.dto.CourseDto.CourseRequest;
import com.example.course_platform.dto.CourseDto.CourseResponse;
import com.example.course_platform.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public CourseResponse createCourse(@Valid @RequestBody CourseRequest req, Principal principal) {
        String createdBy = principal.getName(); // Username dari JWT
        return courseService.createCourse(req, createdBy);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}

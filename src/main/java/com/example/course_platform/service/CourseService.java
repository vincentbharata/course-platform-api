package com.example.course_platform.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course_platform.dto.CourseDto.CourseRequest;
import com.example.course_platform.dto.CourseDto.CourseResponse;
import com.example.course_platform.model.Course;
import com.example.course_platform.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    public CourseResponse createCourse(CourseRequest request, String createdBy) {
        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setCreatedBy(createdBy);
        course = courseRepo.save(course);

        return new CourseResponse(course.getId(), course.getTitle(), course.getDescription(), course.getCreatedBy());
    }

    public List<CourseResponse> getAllCourses() {
        return courseRepo.findAll().stream()
                .map(c -> new CourseResponse(c.getId(), c.getTitle(), c.getDescription(), c.getCreatedBy()))
                .collect(Collectors.toList());
    }

    public CourseResponse getCourseById(Long id) {
        Course c = courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        return new CourseResponse(c.getId(), c.getTitle(), c.getDescription(), c.getCreatedBy());
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}

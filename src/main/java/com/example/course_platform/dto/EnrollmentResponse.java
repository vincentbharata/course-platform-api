package com.example.course_platform.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnrollmentResponse {
    private Long id;
    private String courseTitle;
    private LocalDateTime enrolledDate;
}

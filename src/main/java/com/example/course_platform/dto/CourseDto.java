package com.example.course_platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class CourseDto {

    @Data
    public static class CourseRequest {
        @NotBlank
        @Size(min = 3)
        private String title;

        @NotBlank
        @Size(min = 10)
        private String description;
    }

    @Data
    public static class CourseResponse {
        private Long id;
        private String title;
        private String description;
        private String createdBy;

        public CourseResponse(Long id, String title, String description, String createdBy) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.createdBy = createdBy;
        }
    }
}

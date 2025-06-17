package com.example.course_platform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Course {
    @Id @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String title;

    @NotBlank
    @Size(min = 10)
    private String description;

    @ManyToOne
    private User createdBy;
}

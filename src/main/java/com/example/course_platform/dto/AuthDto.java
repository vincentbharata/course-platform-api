package com.example.course_platform.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class AuthDto {

    @Data
    public static class AuthRequest {
        @NotBlank
        private String username;

        @NotBlank
        private String password;
    }

    @Data
    public static class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }
    }
}

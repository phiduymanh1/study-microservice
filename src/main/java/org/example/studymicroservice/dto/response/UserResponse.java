package org.example.studymicroservice.dto.response;

import java.time.LocalDate;

public record UserResponse(Integer id, String name, String email, LocalDate createdAt) {}

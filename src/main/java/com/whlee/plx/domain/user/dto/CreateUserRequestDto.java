package com.whlee.plx.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDto(
        @NotBlank
        String username,
        @NotBlank
        String name,
        @NotBlank
        String password,
        @Email
        String email
) {}

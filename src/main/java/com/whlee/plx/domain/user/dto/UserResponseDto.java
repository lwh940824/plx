package com.whlee.plx.domain.user.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(
        Long userId,
        String username,
        String name,
        String email
) {}

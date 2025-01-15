package com.whlee.plx.domain.user.service;

import com.whlee.plx.common.exception.CustomException;
import com.whlee.plx.common.exception.ErrorCode;
import com.whlee.plx.domain.user.dto.UserResponseDto;
import com.whlee.plx.domain.user.entity.UserEntity;
import com.whlee.plx.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new Exception(ErrorCode.NOT_FOUND_USER)).toResponseDto();
    }
}

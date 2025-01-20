package com.whlee.plx.domain.user.service;

import com.whlee.plx.common.exception.CustomException;
import com.whlee.plx.common.exception.ErrorCode;
import com.whlee.plx.common.type.UseType;
import com.whlee.plx.domain.user.dto.CreateUserRequestDto;
import com.whlee.plx.domain.user.dto.UserResponseDto;
import com.whlee.plx.domain.user.entity.UserEntity;
import com.whlee.plx.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserResponseDto> selectUserList() {
        return userRepository.findAll().stream().map(UserEntity::toResponseDto).toList();
    }

    @Transactional(readOnly = true)
    public UserResponseDto selectUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER)).toResponseDto();
    }

    @Transactional
    public void createUser(CreateUserRequestDto createUserRequestDto) {
        if (userRepository.existsByUsername(createUserRequestDto.username())) {
            throw new CustomException(ErrorCode.DUPLICATE_USER);
        }
        userRepository.save(UserEntity.builder()
                .username(createUserRequestDto.username())
                .password(createUserRequestDto.password())
                .name(createUserRequestDto.name())
                .email(createUserRequestDto.email())
                .build());
    }

    @Transactional
    public void deleteUser(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));
        userEntity.updateUseSt(UseType.N);
    }
}

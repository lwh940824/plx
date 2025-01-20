package com.whlee.plx.domain.user.controller;

import com.whlee.plx.domain.user.dto.CreateUserRequestDto;
import com.whlee.plx.domain.user.dto.UserResponseDto;
import com.whlee.plx.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> getUserList() {
        return ResponseEntity.ok(userService.selectUserList());
    }

    @GetMapping(name = "/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.selectUser(userId));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid CreateUserRequestDto createUserRequestDto) {
        userService.createUser(createUserRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}

package com.whlee.plx.domain.user.entity;

import com.whlee.plx.common.type.UseType;
import com.whlee.plx.domain.user.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", unique = true, nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "use_st")
    private UseType useSt;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public UserEntity(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserResponseDto toResponseDto() {
        return UserResponseDto.builder()
                .userId(userId)
                .username(username)
                .name(name)
                .email(email)
                .build();
    }

    public void updateUseSt(UseType useSt) {
        this.useSt = useSt;
    }
}

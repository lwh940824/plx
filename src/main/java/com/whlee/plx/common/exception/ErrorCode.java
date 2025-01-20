package com.whlee.plx.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_TOKEN("사용할 수 없는 토큰"),
    NOT_FOUND_USER("사용자 데이터 없음"),
    DUPLICATE_USER("이미 존재하는 사용자");

    final String msg;

    ErrorCode(String msg) {this.msg = msg;}

}

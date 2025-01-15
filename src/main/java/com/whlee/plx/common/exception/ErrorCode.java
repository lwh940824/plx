package com.whlee.plx.common.exception;

public enum ErrorCode {
    NOT_FOUND_USER("사용자 데이터 없음");

    final String msg;

    ErrorCode(String msg) {this.msg = msg;}

    public String getMsg() {return msg;}
}

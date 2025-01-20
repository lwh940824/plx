package com.whlee.plx.common.type;

import lombok.Getter;

@Getter
public enum UseType {
    Y("사용"),
    N("미사용");

    final String msg;

    UseType(String msg) {this.msg = msg;}
}

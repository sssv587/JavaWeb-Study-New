package com.futurebytedance.common;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/18 - 23:34
 * @Description
 */
public enum ResultCodeEnum {
    SUCCESS(200, "success"),
    USERNAME_ERROR(501, "usernameError"),
    PASSWORD_ERROR(503, "passwordError"),
    NOTLOGIN(504, "notlogin"),
    USERNAME_USED(505, "usernameUsed");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

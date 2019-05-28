package com.example.blog.enums;

public enum ResultEnum {
    UNDEFINED_ERROR(-1,"未定义错误"),
    SUCCESS(1,"成功"),
    USER_INEXISTENCE(400,"用户不存在"),
    USER_ERROR(401,"用户名或密码错误"),
    USER_ALREADY_EXIST(402,"用户已经存在")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
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

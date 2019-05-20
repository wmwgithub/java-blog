package com.example.blog.exception;

public class BlogException extends RuntimeException{
    private Integer code;

    public BlogException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

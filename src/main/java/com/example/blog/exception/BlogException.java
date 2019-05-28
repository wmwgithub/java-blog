package com.example.blog.exception;

import com.example.blog.enums.ResultEnum;

public class BlogException extends RuntimeException{
    /**继承自runtimeException 运行时异常**/
    private Integer code;

    public BlogException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

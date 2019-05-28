package com.example.blog.utils;

import com.example.blog.domain.Result;
import com.example.blog.enums.ResultEnum;

public class ResultUtil {
    public static Result  success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(object);
        return  result;
    }
    public static Result success(){
          return  success(null);
    }
    /**暂时 不把fail状态信息封装进 ResultEnum**/
    public static Result  fail(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return  result;
    }
}

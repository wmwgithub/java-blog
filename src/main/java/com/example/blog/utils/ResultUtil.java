package com.example.blog.utils;

import com.example.blog.domain.Result;

public class ResultUtil {
    public static Result  success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(object);
        return  result;
    }
    public static Result success(){
          return  success(null);
    }
    public static Result  fail(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return  result;
    }
}

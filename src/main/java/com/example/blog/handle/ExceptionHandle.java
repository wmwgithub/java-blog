package com.example.blog.handle;

import com.example.blog.domain.Result;
import com.example.blog.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
//public class ExceptionHandle {
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Result handle(Exception e){
//        System.out.println(e.getMessage());
//        return ResultUtil.fail(100,e.getMessage());
//    }
//}

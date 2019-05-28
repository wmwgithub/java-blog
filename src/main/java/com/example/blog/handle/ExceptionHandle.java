package com.example.blog.handle;

import com.example.blog.domain.Result;
import com.example.blog.exception.BlogException;
import com.example.blog.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof BlogException){
            //判断如果异常是我们自己定义的异常
            BlogException blogException = (BlogException) e;
            return ResultUtil.fail(blogException.getCode(),blogException.getMessage());
        }

        //所有异常都被捕获 所以要通过日志打印 让异常信息完整显示在控制台
        logger.error("未定义异常::: ",e);
        //未知异常 返回回如下
        return ResultUtil.fail(-1,e.getMessage());
    }
}

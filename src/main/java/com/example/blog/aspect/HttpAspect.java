//package com.example.blog.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import javax.servlet.http.HttpServletRequest;
//注释掉 这边还没写好 本来计划 是对前端请求做一个统一的过滤；
//@Aspect
//@Component
//public class HttpAspect {
//    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
//    @Pointcut("execution(public * com.example.blog.controller.BlogController.deleteArticle(..))")
//    public void log(){
//
//    }
//
//    @Before("log()")
//    public void doBefore(JoinPoint joinPoint){
//        /**
//         * @url @ip @menthod @class @参数
//         */
//     ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request =attributes.getRequest();
//        logger.info("url={}",request.getRequestURL());
//        logger.info("method={}",request.getMethod());
//        logger.info("ip={}",request.getRemoteAddr());
//        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
//        logger.info("args={}",joinPoint.getArgs());
//        System.out.println(joinPoint.getArgs());
//    }
//    @AfterReturning(returning = "object",pointcut = "log()")
//    public void doAfterReturning(Object object){
//       logger.info("response={}",object);
//    }
//}
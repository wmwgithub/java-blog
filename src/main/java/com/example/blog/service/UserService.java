package com.example.blog.service;

import com.example.blog.domain.Result;
import com.example.blog.domain.User;
import com.example.blog.enums.ResultEnum;
import com.example.blog.exception.BlogException;
import com.example.blog.repository.UserRepository;
import com.example.blog.utils.MD5Util;
import com.example.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户的注册 登录 注销等操作
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    MD5Util md5Util = new MD5Util();
    private Long time;

    /**
     * @param name
     * @param password
     * @return 成功存入数据库的用户
     */
    public Result add(String name, String password) {
        User user = userRepository.findByName(name);//正常情况这一步user==null
        if(user!=null){
            throw new BlogException(ResultEnum.USER_ALREADY_EXIST);
        }
        user = new User();
        password = md5Util.OnlyMD5(password);
        String openId = md5Util.OnlyMD5(name);
//        System.out.println(openId);
        Long time = new Date().getTime();
        user.setName(name);
        user.setPassword(password);
        StringBuilder defaultAvatar = new StringBuilder("https://dummyimage.com/200x100/50B347/FFF&text=");
        defaultAvatar.append(name);
        user.setAvatar(defaultAvatar.toString());
//        System.out.println(user.getAvatar());
        user.setTime(time);
        user.setOpenid(openId);
        user = userRepository.save(user);
        return  ResultUtil.success(user);
    }

    public User find(String openId) {
        return userRepository.findByOpenid(openId);
    }

    /**
     * @param userId
     * @return 验证用户信息是否正确
     */
    public Boolean detectionUser(Integer userId, String password) {
        User user = userRepository.findById(userId).get();
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

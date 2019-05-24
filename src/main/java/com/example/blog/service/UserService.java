package com.example.blog.service;

import com.example.blog.domain.User;
import com.example.blog.repository.UserRepository;
import com.example.blog.utils.MD5Util;
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

    /**
     *
     * @param name
     * @param pwd
     * @return 成功存入数据库的用户
     */
    public User add(String name,String pwd){
     pwd = md5Util.OnlyMD5(pwd);
     String openId = md5Util.OnlyMD5(name);
     System.out.println(openId);
     Long time = new Date().getTime();
     User user = new User();
     user.setName(name);
     user.setPassword(pwd);
     user.setAvatar("default");
     user.setTime(time);
     user.setOpenid(openId);
     return  userRepository.save(user);
    }
    public User find(String openId){
        return userRepository.findByOpenid(openId);
    }
}

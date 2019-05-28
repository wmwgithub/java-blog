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

@Service
public class LoginService extends  UserService{
    @Autowired
    UserRepository userRepository;
    public Result login(String name, String password){
        User user =userRepository.findByName(name);
        /**记得给传进来密码md5加密后再和数据库中密码比较**/
        MD5Util md5Util = new MD5Util();
        password= md5Util.OnlyMD5(password);
        if(user == null){
            throw new BlogException(ResultEnum.USER_INEXISTENCE);
        }
        if(!user.getPassword().equals(password)){
            throw new BlogException(ResultEnum.USER_ERROR);
        }
        return ResultUtil.success(user);
    }
}

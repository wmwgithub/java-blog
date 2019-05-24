package com.example.blog.controller;

import com.example.blog.domain.User;
import com.example.blog.domain.UserInfo;
import com.example.blog.service.LoginService;
import com.example.blog.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*", "null"})
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping(value = "/login")
    public User add(@RequestBody String user) throws Exception {
        ObjectMapper jsonParse = new ObjectMapper();
        UserInfo userInfo = jsonParse.readValue(user, UserInfo.class);
        User userFindOut = loginService.exist(userInfo.getUsername());
        String userName = userFindOut.getName();
        if (userName.equals((""))) {
            throw new Exception("用户不存在");
        } else {
            return userFindOut;
        }
    }
}

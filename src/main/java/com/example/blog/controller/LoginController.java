package com.example.blog.controller;

import com.example.blog.domain.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*","null"})
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/logoin")
    public String add(@RequestBody String user){

        System.out.println(user);
        return  "success";
//        return userService.add(name,password);
    }

}

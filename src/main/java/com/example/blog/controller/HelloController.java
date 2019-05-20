package com.example.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@RequestMapping("/hello")
* */
public class HelloController {
    /*
    * @RequestMapping(value={"/hello","/hi"},method=RequestMethod.GET)
    * @RequestMapping(value="/hello",method=RequestMethod.GET)
     * */
    @GetMapping(value = "/hello")
    public String say(){
        return "hello Spring boot";
    }
}

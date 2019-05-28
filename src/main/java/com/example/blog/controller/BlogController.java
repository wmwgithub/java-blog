package com.example.blog.controller;

import com.example.blog.domain.Article;
import com.example.blog.domain.Result;
import com.example.blog.domain.User;
import com.example.blog.service.ArticleService;
import com.example.blog.service.BlogService;
import com.example.blog.service.UserService;
import com.example.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @GetMapping(value = "/total")
    public Long total(@RequestParam("userid") Integer userId) {
        return blogService.totalArticle(userId);
    }

    @GetMapping(value = "/lists")
    public List<Article> lists(@RequestParam("userid") Integer userid,
                               @RequestParam("page") Integer page,
                               @RequestParam("pageSize") Integer pageSize) {

        return blogService.articleList(userid, page, pageSize);
    }

    @PostMapping(value = "/create")
    public Article create(@RequestParam("userid") Integer userid,
                          @RequestParam("title") String title,
                          @RequestParam("content") String content,
                          @RequestParam("type") Integer type) {
        return articleService.add(userid, title, content, type);
    }

    @DeleteMapping(value = "/delete")
    public Result deleteArticle(@RequestParam("id") Integer id,
                         @RequestParam("userid") Integer userid,
                         @RequestParam("password") String password) {
        //删除之前先验证用户名密码是否正确 确认是不是本人操作
        System.out.println(userid);
        Boolean detection = userService.detectionUser(userid,password);
       if (detection){
          return  articleService.delete(id);
       }
        return  ResultUtil.fail(-1,"用户名密码错误");
    }

    @PostMapping(value = "/update")
    public Article update(@RequestParam("id") Integer id,
                          @RequestParam("title") String title,
                          @RequestParam("content") String content) {
        return articleService.update(id, title, content);
    }

    @GetMapping(value = "/article")
    public Article articleFindOne(@RequestParam("id") Integer id) {
        return articleService.findOne(id);

    }


}

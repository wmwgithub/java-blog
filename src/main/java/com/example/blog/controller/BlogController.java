package com.example.blog.controller;

import com.example.blog.domain.Article;
import com.example.blog.domain.Result;
import com.example.blog.service.ArticleService;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private ArticleService articleService;

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
    public Result delete(@RequestParam("id") Integer id) {
        return articleService.delete(id);
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

    @GetMapping(value = "/search")
    public Article search(@RequestParam("title") String title) {
        return articleService.findOne(title);
    }
}

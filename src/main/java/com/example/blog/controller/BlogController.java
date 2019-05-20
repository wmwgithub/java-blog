package com.example.blog.controller;
import com.example.blog.domain.Article;
import com.example.blog.domain.Result;
import com.example.blog.service.ArticleService;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService ;
    @Autowired
    private ArticleService articleService ;

    @GetMapping(value = "/lists")
    public List<Article> articleList(@RequestParam("userid") Integer userid){
        return blogService.articleList(userid);
    }

    @PostMapping(value = "/create")
    public Article articleAdd(@RequestParam("userid") Integer userid,
                          @RequestParam("title") String title,
                          @RequestParam("content") String content){
        return articleService.add(userid,title,content);
    }

    @GetMapping(value = "/article")
    public Article articleFindOne(@RequestParam("id") Integer id){
        System.out.println(id);
        return articleService.findOne(id);

    }

    @PostMapping(value = "/update")
    public Article articleUpdate(@RequestParam("id") Integer id,
                              @RequestParam("title")String title,
                              @RequestParam("content") String content){
        return articleService.update(id,title,content);
    }

    @DeleteMapping(value = "/delete")
    public Result articleDelete(@RequestParam("id")Integer id){
        return articleService.delete(id);
    }
    @GetMapping(value = "/search")
    public Article searchByTitle(@RequestParam("title")String title)
    {
        return articleService.findOne(title);
    }
}

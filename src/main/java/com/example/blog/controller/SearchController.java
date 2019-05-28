package com.example.blog.controller;

import com.example.blog.domain.Article;
import com.example.blog.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*", "null"})
public class SearchController {
    @Autowired
    private SearchService searchService;
    @GetMapping(value = "/search")
    public List<Article> search(@RequestParam("title") String title) {
        return searchService.findArticle(title);
    }

    @GetMapping("/search/article")
    public Object[] articleInfo(@RequestParam("id") Integer id){
        return searchService.getArticle(id);
    }

}

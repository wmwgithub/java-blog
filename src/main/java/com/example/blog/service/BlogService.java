package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BlogService 对文章的一些批量操作
 */
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    /**
     * @param userId
     * @return 根据用户id返回这个用户的所有文章
     */
    public List<Article> articleList(Integer userId){
        return blogRepository.findByUserid(userId);
    }
}

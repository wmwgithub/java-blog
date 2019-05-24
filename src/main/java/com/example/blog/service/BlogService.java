package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<Article> articleList(Integer userId,Integer page,Integer pageSize) {
         /**
         * @page spring data jpa page从0开始 前端page从1开始
         */
        page--;
        Pageable pageable = PageRequest.of(page,pageSize);
        Article article = new Article();
        article.setUserid(userId);
        /**
         * 创建查询参数模板
         */
        Example<Article> byUserid=Example.of(article);
        return blogRepository.findAll(byUserid,pageable).getContent();
    }

    /**
     * @param userId
     * @return 某个用户的文章总条数
     */
    public Long totalArticle(Integer userId) {
        Long total = blogRepository.countByUserid(userId);
        return total;
    }
}

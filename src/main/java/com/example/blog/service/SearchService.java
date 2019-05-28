package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.domain.User;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;

    /**
     * @param title
     * @return 返回通过文章标题查询的结果
     */
    public List<Article> findArticle(String title) {
        StringBuilder titleArray = new StringBuilder(title);
        Integer titleLength = titleArray.length();
        for (int i = 1, index = 1; i < titleLength; i++) {
            titleArray.insert(index, "%");
            index += 2;
        }
        return blogRepository.findArticleByTitleLike(titleArray.toString());
    }


    public Object[] getArticle(Integer id) {
        /**
         * @article 当前id对应的文章信息
         * @lastArticle 当前文章的上一篇文章
         * @nextArticle 当前文章的下一篇文章
         */
        Article article = new Article();
        Article lastArticle = new Article();
        Article nextArticle = new Article();
        /**获取当前id的文章信息**/
        Object articleInfo = blogRepository.getArticleInfo(id);
        /**获取此id的上一篇文章信息**/
        List<Article> lastArticleList = blogRepository.findLast(id);
        /**获取此id的下一篇文章信息**/
        List<Article> nextArticleList = blogRepository.findNext(id);
        if(articleInfo!=null){
            article.setId((Integer) Array.get(articleInfo,0));
            article.setTitle((String) Array.get(articleInfo,1));
            article.setContent((String) Array.get(articleInfo,2));
            article.setTime(((BigInteger)Array.get(articleInfo,3)).longValue());
            article.setStar((Integer) Array.get(articleInfo,4));
            User user = new User();
            user.setName((String) Array.get(articleInfo,5));
            user.setAvatar((String) Array.get(articleInfo,6));
            article.setUser(user);
        }
        if (!lastArticleList.isEmpty()) {
            lastArticle = lastArticleList.get(0);
        }
        if (!nextArticleList.isEmpty()) {
            nextArticle = nextArticleList.get(0);
        }
        Object [] articleArray={article,lastArticle,nextArticle};
        return  articleArray;
    }
}

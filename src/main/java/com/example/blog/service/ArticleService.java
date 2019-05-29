package com.example.blog.service;

import com.example.blog.domain.Article;
import com.example.blog.domain.Result;
import com.example.blog.domain.User;
import com.example.blog.enums.ResultEnum;
import com.example.blog.exception.BlogException;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

/**
 * 对某一篇文章的增删改查
 */
@Service
public class ArticleService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * 增
     *
     * @param userId  用户ID
     * @param title   文章标题
     * @param content 文章内容
     * @param type    文章类型
     * @return 文章保存到数据库后返回的内容
     */
    public Article add(Integer userId, String title, String content, Integer type) {
        //默认创建文章时star=0；
        Integer star = 0;
        //获取文章创建的时候的时间戳，毫秒级
        Long time = new Date().getTime();
        Article article = new Article();
        article.setUserid(userId);
        article.setTitle(title);
        article.setContent(content);
        article.setStar(star);
        article.setTime(time);
        article.setType(type);
        return blogRepository.save(article);
    }

    /**
     * @param articleId
     * @return 成功删除谋篇文章返回true 删除失败返回false
     */
    public Result delete(Integer articleId) {

        System.out.println(articleId);
        String errMessage = "";
        try {
            blogRepository.deleteById(articleId);
        } catch (Exception e) {
            errMessage = e.getMessage();
            System.out.println("errMessage" + errMessage);
        }
        if (errMessage == "") {
            return ResultUtil.success(true);
        } else {
            return ResultUtil.fail(-1, errMessage);
        }
    }

    /**
     * 改
     *
     * @param id      要更新的文章id
     * @param title   新文章标题
     * @param content 新文章内容
     * @return 文章成功更新后的信息
     */
    public Article update(Integer articleId, String title, String content, Integer type, Integer userId) {
        Long time = new Date().getTime();
        Article article = blogRepository.findById(articleId).get();
        if (article.getUserid() != userId) {
            throw new BlogException(ResultEnum.USER_LIMITED);
        }
        article.setTitle(title);
        article.setContent(content);
        article.setTime(time);
        article.setType(type);
        return blogRepository.save(article);
    }

    /**
     * 查
     *
     * @param id 文章id
     * @return 从数据库里面查出来的这个id的文章
     */
    public Article findOne(Integer id) {
        return blogRepository.findById(id).get();
    }

    public Result modifyArticle(Integer articleId, String openid) {
        //拿到文章信息
        Article article = blogRepository.findById(articleId).get();
        //获取文章作者id
        Integer userId = article.getUserid();
        String openId = userRepository.findOpenidById(userId);
        if (openId.equals(openid)) {
            //openid一样说明是本人操作 返回文章信息
            return ResultUtil.success(article);
        } else {
            //否则返回错误信息
            return ResultUtil.fail(ResultEnum.USER_LIMITED);
        }
    }

}

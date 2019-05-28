package com.example.blog.repository;

import com.example.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogRepository extends JpaRepository<Article, Integer> {


    @Query(value = "select article from  Article article where article.title like concat('%',:title,'%') ")
    public List<Article> findArticleByTitleLike(@Param("title") String title);

    public Article findByTitle(String title);

    public List<Article> findByUserid(Integer userId);

    public Long countByUserid(Integer userId);

    /**
     * @param Id
     * @return 查找数据库中指定id的下一条数据
     */
    /**
     * 自闭 Article  不可以 List<Article> 可以
     **/
    @Query(value = "select * from  article where id> :id LIMIT 1", nativeQuery = true)
    public List<Article> findNext(@Param("id") Integer Id);

    @Query(value = "select * from article where id <:Id order by id desc limit 1", nativeQuery = true)
    public List<Article> findLast(Integer Id);

    @Query(value = "select article.id,article.title,article.content,article.time,article.star,user.name,user.avatar from article left join user on article.userid=user.id where article.id=:Id", nativeQuery = true)
    public Object getArticleInfo(Integer Id);
}

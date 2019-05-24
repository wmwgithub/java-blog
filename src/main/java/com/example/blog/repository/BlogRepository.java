package com.example.blog.repository;

import com.example.blog.domain.Article;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * 下面的写法只能通过年龄来查询
 */
//public interface BlogRepository extends JpaRepository<Article,Integer> {
//}
/**
 * 更改接口
 * 通过文章标题来查询
 */
public interface BlogRepository extends JpaRepository<Article,Integer>{
    public Article findByTitle(String title);
    public List<Article> findByUserid(Integer userId);
    public Long countByUserid(Integer userId);


}

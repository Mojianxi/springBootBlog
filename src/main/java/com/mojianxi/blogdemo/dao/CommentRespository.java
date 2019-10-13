package com.mojianxi.blogdemo.dao;

import com.mojianxi.blogdemo.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/12 20:09
 * @Company dyld
 */
public interface CommentRespository extends JpaRepository<Comment,Long> {
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}

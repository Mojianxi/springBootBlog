package com.mojianxi.blogdemo.service;

import com.mojianxi.blogdemo.po.Comment;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/12 20:06
 * @Company dyld
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);
    Comment saveComment(Comment comment);
}

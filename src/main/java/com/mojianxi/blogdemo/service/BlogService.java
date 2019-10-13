package com.mojianxi.blogdemo.service;

import com.mojianxi.blogdemo.po.Blog;
import com.mojianxi.blogdemo.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/11 10:09
 * @Company dyld
 */
public interface BlogService {
    Blog getBlog(Long id);
    Blog getAndConvert(Long id);
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
    Page<Blog> listBlog(Long tagId,Pageable pageable);
    Page<Blog> listBlog(Pageable pageable);
    Page<Blog> listBlog(String query,Pageable pageable);
    List<Blog> listRecommendBlogTop(Integer size);
    Map<String,List<Blog>> archiveBlog();
    Blog saveBlog(Blog blog);
    Blog updateBlog(Long id,Blog blog);
    void deleteBlog(Long id);
    Long countBlog();
}

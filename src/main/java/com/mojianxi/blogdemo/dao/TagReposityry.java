package com.mojianxi.blogdemo.dao;

import com.mojianxi.blogdemo.po.Tag;
import com.mojianxi.blogdemo.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/10 12:50
 * @Company dyld
 */
public interface TagReposityry extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}

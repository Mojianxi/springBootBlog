package com.mojianxi.blogdemo.dao;

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
public interface TypeReposityry extends JpaRepository<Type,Long> {
    Type findByName(String name);
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}

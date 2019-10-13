package com.mojianxi.blogdemo.service;

import com.mojianxi.blogdemo.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/10 12:46
 * @Company dyld
 */
public interface TypeService {
    Type saveType(Type type);
    Type getType(Long id);
    Type getTypeByname(String name);
    Page<Type> listType(Pageable pageable);
    List<Type> listType();
    List<Type> listTypeTop(Integer size);
    Type updateType(Long id,Type type);
    void deleteType(Long id);
}

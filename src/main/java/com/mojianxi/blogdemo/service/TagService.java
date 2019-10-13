package com.mojianxi.blogdemo.service;

import com.mojianxi.blogdemo.po.Tag;
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
public interface TagService {
    Tag saveType(Tag tag);
    Tag getType(Long id);
    Tag getTypeByname(String name);
    Page<Tag> listType(Pageable pageable);
    List<Tag> listTag();
    List<Tag> listTag(String ids);
    List<Tag> listTagTop(Integer size);
    Tag updateType(Long id, Tag type);
    void deleteType(Long id);
}

package com.mojianxi.blogdemo.service;

import com.mojianxi.blogdemo.NotFoundException;
import com.mojianxi.blogdemo.dao.TagReposityry;
import com.mojianxi.blogdemo.po.Tag;
import com.mojianxi.blogdemo.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/10 12:49
 * @Company dyld
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagReposityry tagReposityry;
    @Transactional
    @Override
    public Tag saveType(Tag tag) {
        return tagReposityry.save(tag);
    }
    @Transactional
    @Override
    public Tag getType(Long id) {
        return tagReposityry.getOne(id);
    }

    @Override
    public Tag getTypeByname(String name) {
        return tagReposityry.findByName(name);
    }

    @Override
    public Page<Tag> listType(Pageable pageable) {
        return tagReposityry.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagReposityry.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagReposityry.findAllById(convertTolist(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort=new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable=new PageRequest(0,size,sort);
        return tagReposityry.findTop(pageable);
    }

    private List<Long> convertTolist(String ids){
        List<Long> list=new ArrayList<>();
        if(!"".equals(ids)&&ids!=null){
            String[] idArray=ids.split(",");
            for (int i=0;i<idArray.length;i++){
                list.add(new Long(idArray[i]));
            }
        }
        return list;
    }
    @Transactional
    @Override
    public Tag updateType(Long id, Tag tag) {
        Tag t=tagReposityry.getOne(id);
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(tag,t);
        return tagReposityry.save(t);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        tagReposityry.deleteById(id);
    }
}

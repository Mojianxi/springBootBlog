package com.mojianxi.blogdemo.service;

import com.mojianxi.blogdemo.NotFoundException;
import com.mojianxi.blogdemo.dao.TypeReposityry;
import com.mojianxi.blogdemo.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/10 12:49
 * @Company dyld
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeReposityry typeReposityry;
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeReposityry.save(type);
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeReposityry.getOne(id);
    }

    @Override
    public Type getTypeByname(String name) {
        return typeReposityry.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeReposityry.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeReposityry.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort=new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable=new PageRequest(0,size,sort);
        return typeReposityry.findTop(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t=typeReposityry.getOne(id);
        if(t==null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeReposityry.save(t);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeReposityry.deleteById(id);
    }
}

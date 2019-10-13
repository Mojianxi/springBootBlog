package com.mojianxi.blogdemo.service;

import com.mojianxi.blogdemo.po.User;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/10 8:21
 * @Company dyld
 */
public interface UserService {
    User checkUser(String username,String password);
}

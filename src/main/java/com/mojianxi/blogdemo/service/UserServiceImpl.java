package com.mojianxi.blogdemo.service;

import com.mojianxi.blogdemo.dao.UserRepository;
import com.mojianxi.blogdemo.po.User;
import com.mojianxi.blogdemo.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/10 8:24
 * @Company dyld
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user=userRepository.findUserByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}

package com.mojianxi.blogdemo.dao;

import com.mojianxi.blogdemo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/10 8:25
 * @Company dyld
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsernameAndPassword(String username,String password);
}

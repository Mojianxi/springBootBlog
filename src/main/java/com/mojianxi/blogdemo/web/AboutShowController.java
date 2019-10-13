package com.mojianxi.blogdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/13 13:07
 * @Company dyld
 */
@Controller
public class AboutShowController {
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}

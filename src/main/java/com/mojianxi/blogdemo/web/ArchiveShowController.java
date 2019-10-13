package com.mojianxi.blogdemo.web;

import com.mojianxi.blogdemo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/13 12:47
 * @Company dyld
 */
@Controller
public class ArchiveShowController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archiveMap",blogService.archiveBlog());
        model.addAttribute("blogCount",blogService.countBlog());
        return "archives";
    }
}

package com.mojianxi.blogdemo.web;

import com.mojianxi.blogdemo.po.Type;
import com.mojianxi.blogdemo.service.BlogService;
import com.mojianxi.blogdemo.service.TypeService;
import com.mojianxi.blogdemo.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/13 0:58
 * @Company dyld
 */
@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;
    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size=10,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, @PathVariable Long id, Model model){
        List<Type> types=typeService.listTypeTop(10000);
        if(id==-1){
            id=types.get(0).getId();
        }
        BlogQuery blogQuery=new BlogQuery();
        blogQuery.setTypeId(id);
        System.out.println("当前博客id"+blogQuery.getTypeId());
        model.addAttribute("types",types);
        model.addAttribute("page",blogService.listBlog(pageable,blogQuery));
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}

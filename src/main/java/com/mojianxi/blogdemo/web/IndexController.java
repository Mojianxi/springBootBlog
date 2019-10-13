package com.mojianxi.blogdemo.web;

import com.mojianxi.blogdemo.NotFoundException;
import com.mojianxi.blogdemo.service.BlogService;
import com.mojianxi.blogdemo.service.TagService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/9 17:07
 * @Company jjcw
 */
@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    @GetMapping("/")
    public String index(@PageableDefault(size=10,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
//        int i=9/0;
//        String blog=null;
//        if(blog==null){
//            throw  new NotFoundException("博客不存在");
//        }
//        System.out.println("--------------index------------------");
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(8));
        return "index";
    }
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "blog";
    }
    @PostMapping("/search")
    public String search(@PageableDefault(size=10,sort = {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable, @RequestParam String query, Model model){
            model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));
            model.addAttribute("query",query);
        return "search";
    }
    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        model.addAttribute("newblogs",blogService.listRecommendBlogTop(3));
        return "_fragments::newblogList";
    }
}

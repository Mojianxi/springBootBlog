package com.mojianxi.blogdemo.web.admin;

import com.mojianxi.blogdemo.po.Comment;
import com.mojianxi.blogdemo.po.User;
import com.mojianxi.blogdemo.service.BlogService;
import com.mojianxi.blogdemo.service.CommentService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/12 20:01
 * @Company dyld
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    @GetMapping("comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        System.out.println("当前测试数据id"+blogId);
        System.out.println("当前测试数据------"+commentService.listCommentByBlogId(blogId));
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blog::commentList";
    }
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        Long blogId=comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar("https://picsum.photos/id/1025/100/100");
        }
        commentService.saveComment(comment);
        return "redirect:/comments/"+blogId;
    }
}

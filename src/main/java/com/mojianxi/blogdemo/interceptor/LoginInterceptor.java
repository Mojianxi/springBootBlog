package com.mojianxi.blogdemo.interceptor;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author:liuxiaodong
 * @Date 2019/10/10 11:24
 * @Company dyld
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user")==null){
            response.sendRedirect("/admin");
            return false;
        }
        return true;
//        return super.preHandle(request, response, handler);
    }
}

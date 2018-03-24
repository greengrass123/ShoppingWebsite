package com.netease.shopping.interceptor;

import com.netease.shopping.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yuanchuang on 2018-3-1.
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();

        if(url.indexOf("login")>=0||url.indexOf("index")>0||url.equals("/")){
            return true;
        }
        //获取Session
        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");

        if(user != null){
            return true;
        }
        httpServletResponse.sendRedirect("/");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

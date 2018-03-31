package com.netease.shopping.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by yuanchuang on 2018-3-31.
 */
public class TokenInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session=httpServletRequest.getSession(true);
        String serverToken =(String)session.getAttribute("token");
        if(serverToken ==null){
            session.setAttribute("token", UUID.randomUUID().toString());
            return true;
        }else{
            String clinetToken=(String)httpServletRequest.getParameter("token");
            if(clinetToken==null){
                return false;
            }else{
                if(!clinetToken.equals(serverToken)){
                    return false;
                }else{
                    session.removeAttribute("token");
                    return true;
                }
            }

        }

    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

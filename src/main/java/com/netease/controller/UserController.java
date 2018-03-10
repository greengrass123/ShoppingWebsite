package com.netease.controller;

import com.netease.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.netease.service.UserService;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yuanchuang on 2018-2-25.
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController  {
    @Autowired
    private UserService UserService;

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value="/loginJump",method= RequestMethod.GET)
    public ModelAndView loginJump(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value="/Login",method= RequestMethod.POST)
    public ModelAndView getUser(@RequestParam("userName") String userName,    @RequestParam("password") String password) {
        User userLogin= UserService.getUsersByName(userName);
        ModelAndView modelAndView=new ModelAndView();
        if(userLogin==null){
            modelAndView.addObject("msg","无此用户");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if(userLogin.getPassword().equals(password)){
            modelAndView.addObject("user",userLogin);//通过sessionAttributes注解，这步可以将user添加到session中
            modelAndView.setViewName("index");
            return modelAndView;
        }else{
            modelAndView.addObject("msg","登录失败");
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    @RequestMapping("/loginOut")
    public ModelAndView loginOut(SessionStatus sessionStatus){
        sessionStatus.setComplete();//清除session
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

package com.netease.controller;

import com.netease.entity.Commodity;
import com.netease.entity.User;
import com.netease.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.netease.service.UserService;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.netease.constant.StatusCode.S1000;
import static com.netease.constant.StatusCode.S2001;
import static com.netease.constant.StatusCode.S2002;

/**
 * Created by yuanchuang on 2018-2-25.
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController  {
    @Autowired
    private UserService UserService;

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public ModelAndView loginJump(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }



    @ResponseBody
    @RequestMapping(value="/loginJump",method= RequestMethod.POST)
    public ModelAndView getUser(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletResponse response) {
        User userLogin= UserService.getUsersByName(userName);
        ModelAndView modelAndView=new ModelAndView();
        try {
           PrintWriter printWriter= response.getWriter();
            if(userLogin==null){
                printWriter.print(S2001);
                return null;
            }
            if(userLogin.getPassword().equals(password)){
                modelAndView.addObject("user",userLogin);//通过sessionAttributes注解，这步可以将user添加到session中
                modelAndView.setViewName("index");
                return modelAndView;
            }else{
               printWriter.print(S2002);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    @RequestMapping("/loginOut")
    public String loginOut(SessionStatus sessionStatus,HttpServletResponse response){
        sessionStatus.setComplete();//清除session


        return "redirect:/" ;
    }
}

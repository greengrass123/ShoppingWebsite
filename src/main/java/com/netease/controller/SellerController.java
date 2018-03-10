package com.netease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yuanchuang on 2018-3-10.
 */
@Controller
@RequestMapping("/seller")
public class SellerController {

    @RequestMapping("/publish")
    public ModelAndView publish(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("publish");
        return modelAndView;
    }

}

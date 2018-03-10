package com.netease.controller;

import com.netease.entity.Commodity;
import com.netease.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by yuanchuang on 2018-3-8.
 */

/**
 * 设置首页为index.jsp
 */
@Controller
public class HomePageController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping({"/"})
    public ModelAndView indexCore(HttpServletRequest request, HttpServletResponse response) {
        List<Commodity> commodityList = commodityService.selectAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("commodityList",commodityList);
        return modelAndView;
    }
}

package com.netease.controller;

import com.netease.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.netease.service.userService;
import java.util.List;

/**
 * Created by yuanchuang on 2018-2-25.
 */
@Controller
public class UserController  {
    @Autowired
    private userService userService;

    @RequestMapping(value="/getUser",method= RequestMethod.GET)
    public String getUser(@RequestParam Integer userId) {
        List<user> users = userService.getUsers(userId);
       /*测试用
      if(employees==null)
         System.out.println("null");
      else
         System.out.println(employees);*/
        System.out.println(users.get(0).getUserName());
        return "list";
    }
}

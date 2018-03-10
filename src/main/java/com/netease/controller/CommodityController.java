package com.netease.controller;

import com.netease.entity.Commodity;
import com.netease.entity.User;
import com.netease.service.CommodityService;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by yuanchuang on 2018-3-8.
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private UserService userService;

    @RequestMapping("/addCommodity")
    public ModelAndView addCommodity(@RequestParam("imgUrl") MultipartFile imgUrl, @RequestParam("title") String title, @RequestParam("summary") String summary,
                                     @RequestParam("text") String text, @RequestParam("price") int price, HttpServletRequest request)throws IOException {

        // requestParam已经要求必须有值，前端也已经校验，所以不再对参数是否为空校验
        String originalFilename = imgUrl.getOriginalFilename();
        ModelAndView modelAndView = new ModelAndView();
        String type = originalFilename.indexOf(".") != -1 ? originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length()) : null;
        if (type != null) {// 判断文件类型是否为空
            if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                String path=request.getSession().getServletContext().getRealPath("resources/images/");
                   // 自定义的文件名称
                String fileName=String.valueOf(System.currentTimeMillis());
                String realFilePath=path + fileName+"."+type;
                File file = new File(realFilePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                imgUrl.transferTo(file);
                Commodity commodity=new Commodity(title,summary,realFilePath,text,price);
                Timestamp publishTime = new Timestamp(System.currentTimeMillis());
                commodity.setPublishTime(publishTime);
                HttpSession session=request.getSession();
                User user=null;
                if(session.getAttribute("user")!=null){
                    user=(User)session.getAttribute("user");
                    commodity.setId(user.getId());;
                    commodityService.insertCommodity(commodity);
                    modelAndView.setViewName("publishSuccess");
                }else {
                    modelAndView.setViewName("publish");
                    modelAndView.addObject("msg","session已经过期");
                }
            }else{
                modelAndView.setViewName("publish");
                modelAndView.addObject("msg","不是我们想要的文件类型,请按要求重新上传");
                System.out.println("不是我们想要的文件类型,请按要求重新上传");
            }
        }else{
            modelAndView.setViewName("publish");
            modelAndView.addObject("msg","文件类型为空");
            System.out.println("文件类型为空");
        }

        return modelAndView;
    }

    @RequestMapping("upadteCommodity")
    public ModelAndView updateCommodity(@RequestParam("title") String title, @RequestParam("summary") String summary,
                                        @RequestParam("text") String text, @RequestParam("price") int price){
        return null;
    }


}

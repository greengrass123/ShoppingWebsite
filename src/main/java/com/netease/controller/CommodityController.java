package com.netease.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.netease.entity.Commodity;
import com.netease.entity.Purchase;
import com.netease.entity.User;
import com.netease.service.CommodityService;
import com.netease.service.PurchaseService;
import com.netease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.netease.constant.StatusCode.ER7001;
import static com.netease.constant.StatusCode.ER7002;
import static com.netease.constant.StatusCode.S1000;

/**
 * Created by yuanchuang on 2018-3-8.
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private UserService userService;

    @RequestMapping("/publish")
    public ModelAndView publish(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("publish");
        return modelAndView;
    }

    @RequestMapping("/addCommodity")
    public ModelAndView addCommodity(@RequestParam("imgPath") String imgPath, @RequestParam("title") String title, @RequestParam("summary") String summary,
                                     @RequestParam("text") String text, @RequestParam("price") double price, HttpServletRequest request) throws IOException {

        // requestParam已经要求必须有值，前端也已经校验，所以不再对参数是否为空校验

        ModelAndView modelAndView = new ModelAndView();
        int image_source=0;
        //前端使用了两种上传方式，名字设置相同，所以在接受时会放到一个数组中，转化后会有逗号
        if(imgPath.startsWith(",images")){//本地上传名字在后面，前面是网络图片，为空所以前面有逗号
            imgPath=imgPath.split(",")[1];
            image_source=2;
        }else if (imgPath.startsWith("http:")){//网络图片名字在前面，后面是本地上传图片，为空所以后面有逗号
            imgPath=imgPath.split(",")[0];
            image_source=1;
        }else {
            modelAndView.setViewName("publish");
            modelAndView.addObject("msg", "无效的上传路径");
            return  modelAndView;
        }
        Commodity commodity = new Commodity(title, summary,imgPath,image_source, text, price, 0);

        HttpSession session = request.getSession();
        User user = null;
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            commodity.setUserID(user.getId());
            commodityService.insertCommodity(commodity);
            int id=commodityService.findLastRecord().getId();
            modelAndView.addObject("id",id);
            modelAndView.setViewName("publishSuccess");
        } else {
            modelAndView.setViewName("publish");
            modelAndView.addObject("msg", "session已经过期");
        }

        return modelAndView;
    }

    @RequestMapping("/detail")
    public ModelAndView updateCommodityBefore(@RequestParam("id") int id,HttpServletRequest request) {
        Commodity commodity=commodityService.findById(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("details");
        if(commodity==null){
            modelAndView.addObject("msg","无此商品");
            return modelAndView;
        }
        User user=(User)request.getSession().getAttribute("user");
        if(user.getType()==1){
            List<Purchase> purchaseList=purchaseService.selectPurchaseByCommodityId(commodity.getId());
            if(purchaseList.isEmpty()){//说明通过商品ID没有查到购买记录
                modelAndView.addObject("bought",0);//使用数字0表示没有购买过
            }else{
                modelAndView.addObject("bought",1);//使用数字1表示购买过
                modelAndView.addObject("buyPrice",purchaseList.get(0).getPrice());
            }
        }
        modelAndView.addObject("commodity",commodity);
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView upadteCommodityBefore(@RequestParam("id") Integer id) {
        Commodity commodity=commodityService.findById(id);//通过ID查找商品
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("commodity",commodity);
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @RequestMapping("/upadteCommodity")
    public ModelAndView updateCommodity(@RequestParam("id") int id, @RequestParam("imgPath") String imgPath, @RequestParam("title") String title, @RequestParam("summary") String summary,
                                        @RequestParam("text") String text, @RequestParam("price") double price, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        int image_source=0;
        //前端使用了两种上传方式，名字设置相同，所以在接受时会放到一个数组中，转化后会有逗号
        if(imgPath.startsWith(",images")){//本地上传名字在后面，前面是网络图片，为空所以前面有逗号
            imgPath=imgPath.split(",")[1];
            image_source=2;
        }else if (imgPath.startsWith("http:")){//网络图片名字在前面，后面是本地上传图片，为空所以后面有逗号
            imgPath=imgPath.split(",")[0];
            image_source=1;
        }else {
            modelAndView.setViewName("edit");
            modelAndView.addObject("msg", "无效的上传路径");
            return modelAndView;
        }
        Commodity commodity = new Commodity(id,title, summary, imgPath,image_source, text, price);
        commodityService.updateCommodity(commodity);
        modelAndView.setViewName("publishSuccess");
        return modelAndView;
    }



    @RequestMapping("/findCommodityById")
    public ModelAndView findCommodityById(@RequestParam("id") int id) {
        Commodity commodity = commodityService.findById(id);//通过ID查找商品
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("commodity", commodity);
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @RequestMapping("/findAllCommodity")
    public ModelAndView findAllCommodity() {
        List<Commodity> commodityList = commodityService.selectAll();//查找所有的商品
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("commodityList", commodityList);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/findNoSellCommodity")
    public ModelAndView  findNoSellCommodity(){
        List<Commodity> noSellCommodityList=commodityService.findNoSellCommodity();//查找没有卖出的商品，根据商品卖出数量判断
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("noSellCommodityList",noSellCommodityList);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/deleteNoSellCommodity")
    public void deleteNoSellCommodity(@RequestParam("id") int id, HttpServletResponse response){
        int flag=commodityService.deleteCommodityById(id);//根据ID删除商品
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(flag);
        out.print(JSONUtils.toJSONString(list));
        out.flush();
    }


    @ResponseBody
    @RequestMapping("/upload")
    public void update(@RequestParam("imgUrl") MultipartFile imgUrl, HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        List<String> list = new ArrayList<String>();
        list.add(outputImage(imgUrl, request));
        out.print(JSONUtils.toJSONString(list));
        out.flush();
    }


    public String outputImage(MultipartFile imgUrl, HttpServletRequest request) throws IOException {
        String originalFilename = imgUrl.getOriginalFilename();
        String type = originalFilename.indexOf(".") != -1 ? originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length()) : null;
        if (type != null) {// 判断文件类型是否为空
            if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                String path1 = request.getSession().getServletContext().getRealPath("/");

                // 自定义的文件名称
                String fileName = String.valueOf(System.currentTimeMillis());
                String mysqlPath = "images\\" + fileName + "." + type;
                String realFilePath = path1 + mysqlPath;
                File file = new File(realFilePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                imgUrl.transferTo(file);
                return mysqlPath;
            } else {
                return ER7001;
            }
        } else {
            return ER7002;
        }
    }


}

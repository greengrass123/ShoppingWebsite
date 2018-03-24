package com.netease.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.netease.entity.Commodity;
import com.netease.entity.Purchase;
import com.netease.entity.ShoppingCart;
import com.netease.service.CommodityService;
import com.netease.service.PurchaseService;
import com.netease.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuanchuang on 2018-3-12.
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private CommodityService commodityService;

    private static final Logger log = LoggerFactory.getLogger(PurchaseController.class);

    /**
     * 添加物品到购物车
     * @param id
     * @param price
     * @param amount
     * @param response
     */
    @RequestMapping("/addShoppingCart")
    public void addShoppingCart(@RequestParam("id")int id, @RequestParam("price")double price, @RequestParam("amount")int amount, HttpServletResponse response) {
        ShoppingCart shoppingCart=new ShoppingCart(price,amount,id);
        shoppingCartService.insertShoppingCart(shoppingCart);//插入购物数据
        try{
            List<String> list=new ArrayList<String>();
            list.add("购买成功");
            response.getWriter().print(JSONUtils.toJSONString(list));
        }catch (IOException e){
            log.debug("输出失败");
        }
    }

    /**
     * 展示购物车
     * @return
     */
    @RequestMapping("/shoppingCart")
    public ModelAndView shoppingCart(){
        ModelAndView modelAndView=new ModelAndView();
        List<ShoppingCart> shoppingCartList=shoppingCartService.selectAll();
        HashMap<Integer,Commodity> commodityHashMap=new HashMap<Integer, Commodity>();
        for(int i=0;i<shoppingCartList.size();i++){
            int commodityID=shoppingCartList.get(i).getCommodityID();
            if(commodityHashMap.get(commodityID)==null){
                Commodity commodity=commodityService.findById(commodityID);//通过购物车中的记录中商品ID，通过商品表查找具体是那个商品，并在map中一一对应
                commodityHashMap.put(commodityID,commodity);
            }
        }
        modelAndView.addObject("commodityHashMap",commodityHashMap);
        modelAndView.addObject("shoppingCartList",shoppingCartList);
        modelAndView.setViewName("shoppingCart");
        return modelAndView;
    }

    /**
     * 购物车结算
     * @param shoppingCarts
     * @param response
     */
    @RequestMapping("/settlement")
    public void settlement(@RequestBody List<ShoppingCart> shoppingCarts, HttpServletResponse response){

        String msg="";
        if(shoppingCarts.size()==0){
            msg="没有添加商品在购物车";
        }else{
            msg="付款成功";
            purchaseService.settlement(shoppingCarts);
        }
        try{
            List<String> list=new ArrayList<String>();
            list.add(msg);
            response.getWriter().print(JSONUtils.toJSONString(list));
        }catch (IOException e){
            log.debug("输出失败");
        }
    }

    @RequestMapping("/account")
    public ModelAndView account(){
        List<Purchase> purchaseList=purchaseService.selectAll();
        double total=0;
        DecimalFormat dFormat=new DecimalFormat("#.00");
        HashMap<Integer,Commodity> commodityHashMap=new HashMap<Integer, Commodity>();
        for(int i=0;i<purchaseList.size();i++){
            int commodityID=purchaseList.get(i).getCommodityID();
            if(commodityHashMap.get(commodityID)==null){
                Commodity commodity=commodityService.findById(commodityID);//通过购买记录中商品ID，通过商品表查找具体是那个商品，并在map中一一对应
                commodityHashMap.put(commodityID,commodity);
            }
            total+=purchaseList.get(i).getAmount()*purchaseList.get(i).getPrice();
        }
        total=Double.valueOf(dFormat.format(total));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("commodityHashMap",commodityHashMap);
        modelAndView.addObject("purchaseList",purchaseList);
        modelAndView.addObject("total",total);
        modelAndView.setViewName("account");
        return modelAndView;
    }



}

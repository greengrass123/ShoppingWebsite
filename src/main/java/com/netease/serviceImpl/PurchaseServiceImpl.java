package com.netease.serviceImpl;

import com.netease.dao.mapper.PurchaseMapper;
import com.netease.entity.Purchase;
import com.netease.entity.ShoppingCart;
import com.netease.service.CommodityService;
import com.netease.service.PurchaseService;
import com.netease.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-12.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private CommodityService commodityService;

    public void insertPurchase(Purchase purchase) {

        purchaseMapper.insertPurchase(purchase);
    }
    @Transactional
    public void settlement(List<ShoppingCart> shoppingCarts){
        /**
         * 结算时需要添加事务，更新商品表中的购买数量和删除购物车中数据，最后更新购买记录表
         */
        for(int i=0;i<shoppingCarts.size();i++){
            ShoppingCart shoppingCart=shoppingCarts.get(i);
            Purchase purchase=new Purchase(shoppingCart.getPrice(),shoppingCart.getAmount(),shoppingCart.getCommodityID(),shoppingCart.getBuy_time());
            commodityService.updateAmount(shoppingCart.getCommodityID(),shoppingCart.getAmount());//更新已经购买数量
            shoppingCartService.deleteShopingCartById(shoppingCart.getId());//删除购物车中已经结算的数据
            this.insertPurchase(purchase);

        }
    }


    public Integer deletePurchaseById(int purchaseID) {
        purchaseMapper.deletePurchaseById(purchaseID);
        return null;
    }

    public Purchase findById(int id) {
        purchaseMapper.findById(id);
        return null;
    }

    public Integer updatePurchase(Purchase purchase) {
        purchaseMapper.updatePurchase(purchase);
        return null;
    }

    public List<Purchase> selectAll() {

        return  purchaseMapper.selectAll();
    }

    public List<Purchase> selectPurchaseByCommodityId(int commodityID) {

        return purchaseMapper.selectPurchaseByCommodityId(commodityID);
    }
}

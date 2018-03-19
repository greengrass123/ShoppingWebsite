package com.netease.service;

import com.netease.entity.Purchase;
import com.netease.entity.ShoppingCart;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-12.
 */
public interface PurchaseService {
    public void insertPurchase(Purchase purchase);

    public Integer deletePurchaseById(int purchaseID);

    public Purchase findById(int id);

    public Integer updatePurchase(Purchase purchase);

    public List<Purchase> selectAll();

    public List<Purchase> selectPurchaseByCommodityId(int commodityID);

    public void settlement(List<ShoppingCart> shoppingCarts);
}

package com.netease.service;

import com.netease.entity.ShoppingCart;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-12.
 */
public interface ShoppingCartService {
    public void insertShoppingCart(ShoppingCart shoppingCart);
    public Integer deleteShopingCartById(int id);
    public Integer updateShoppingCart(ShoppingCart shoppingCart);
    public ShoppingCart findById(int id);
    public List<ShoppingCart> selectAll();
}

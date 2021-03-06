package com.netease.shopping.dao.mapper;

import com.netease.shopping.entity.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-12.
 */
@Repository
public interface ShoppingCartMapper {
    public void insertShoppingCart(ShoppingCart shoppingCart);
    public Integer deleteShoppingCartById(int id);
    public Integer updateShoppingCart(ShoppingCart shoppingCart);
    public ShoppingCart findById(int id);
    public List<ShoppingCart> selectAll();
    public List<ShoppingCart> findShoppingCartByCommodityID(int commodityID);
    public void  deleteShoppingCartByCommodityID(int commodityID);
}

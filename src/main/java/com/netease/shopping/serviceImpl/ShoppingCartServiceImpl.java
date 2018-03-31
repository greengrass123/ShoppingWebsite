package com.netease.shopping.serviceImpl;

import com.netease.shopping.dao.mapper.ShoppingCartMapper;
import com.netease.shopping.entity.ShoppingCart;
import com.netease.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-12.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    public void insertShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartMapper.insertShoppingCart(shoppingCart);
    }

    public Integer deleteShopingCartById(int id) {
        return  shoppingCartMapper.deleteShoppingCartById(id);
    }

    public Integer updateShoppingCart(ShoppingCart shoppingCart) {
        return null;
    }

    public ShoppingCart findById(int id) {
        return null;
    }

    public List<ShoppingCart> selectAll() {
        return shoppingCartMapper.selectAll();
    }

    public List<ShoppingCart> findShoppingCartByCommodityID(int commodityID) {
        return shoppingCartMapper.findShoppingCartByCommodityID(commodityID);
    }

    public void deleteShoppingCartByCommodityID(int commodityID) {
        shoppingCartMapper.deleteShoppingCartByCommodityID(commodityID);
    }

}

package com.netease.dao.mapper;

import com.netease.entity.Purchase;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-12.
 */
@Repository
public interface PurchaseMapper {
    /**
     * 插入购买商品记录
     * @param purchase
     */
    public void insertPurchase(Purchase purchase);

    /**
     * 删除购买商品记录
     * @param purchaseID
     * @return
     */
    public Integer deletePurchaseById(int purchaseID);

    /**
     * 用商品购买记录ID查找商品购买记录
     * @param id
     * @return
     */
    public Purchase findById(int id);

    /**
     * 更新购买记录
     * @param purchase
     * @return
     */
    public Integer updatePurchase(Purchase purchase);

    /**
     * 查找所有
     * @return
     */
    public List<Purchase> selectAll();

    /**
     * 用商品ID查找商品购买记录
     * @param commodityID
     * @return
     */
    public List<Purchase> selectPurchaseByCommodityId(int commodityID);
}

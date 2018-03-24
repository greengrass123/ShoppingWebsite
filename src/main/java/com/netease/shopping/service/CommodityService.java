package com.netease.shopping.service;

import com.netease.shopping.entity.Commodity;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-8.
 */
public interface CommodityService {

    public Integer insertCommodity(Commodity commodity);

    public Integer deleteCommodityById(int commodityID);

    public Commodity findById(int commodityID);

    public Integer updateCommodity(Commodity commodity);

    public List<Commodity> selectAll();

    /**
     * 通过id更新数量,数据库中已有数量加上amount
     * @param id
     * @param amount
     */
    public void updateAmount(Integer id ,Integer amount);

    /**
     * 查找没有卖出的那些商品
     * @return
     */
    public List<Commodity> findNoSellCommodity();
    /**
     * 查找最后一条数据
     * @return
     */
    public Commodity findLastRecord();

    /**
     * 统计表中记录总数
     * @return
     */
    public int count();
}

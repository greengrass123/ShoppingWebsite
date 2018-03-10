package com.netease.service;

import com.netease.entity.Commodity;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-8.
 */
public interface CommodityService {
    public void insertCommodity(Commodity commodity);
    public Integer deleteCommodityById(int commodityID);
    public Commodity findById(int commodityID);
    public Integer updateCommodity(Commodity commodity);
    public List<Commodity> selectAll();
}

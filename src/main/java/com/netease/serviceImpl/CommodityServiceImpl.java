package com.netease.serviceImpl;

import com.netease.dao.mapper.CommodityMapper;
import com.netease.entity.Commodity;
import com.netease.service.CommodityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.netease.constant.StatusCode.ER5001;
import static com.netease.constant.StatusCode.ER6001;
import static com.netease.constant.StatusCode.S1000;

/**
 * Created by yuanchuang on 2018-3-8.
 */
@Service
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    private CommodityMapper commodityMapper;

    private static final Logger log = LoggerFactory.getLogger(CommodityServiceImpl.class);

    public Integer insertCommodity(Commodity commodity) {
        return  commodityMapper.insertCommodity(commodity);
    }

    public Integer deleteCommodityById(int commodityID) {
        if(commodityID<0){
            return ER5001;
        }
        if(commodityMapper.deleteCommodityById(commodityID)!=1){
            log.debug("delete fail commodityID is"+commodityID);
            return ER6001;
        }
        return S1000;
    }

    public Commodity findById(int commodityID) {
        if(commodityID<0){
            return null;
        }
        return commodityMapper.findById(commodityID);
    }

    public Integer updateCommodity(Commodity commodity) {
        if(commodity==null){
            return ER5001;
        }
        if(commodityMapper.updateCommodity(commodity)==0){
            log.debug("update fail commodityID is"+commodity.getId());
            return ER6001;
        }
        return S1000;
    }

    public List<Commodity> selectAll() {
        return commodityMapper.selectAll();
    }

    public void updateAmount(Integer id, Integer amount) {
        commodityMapper.updateAmount(id,amount);
    }

    public List<Commodity> findNoSellCommodity() {
        return  commodityMapper.findNoSellCommodity();
    }
    /**
     * 查找最后一条数据
     * @return
     */
    public Commodity findLastRecord(){
       return commodityMapper.findLastRecord();
    }
}

package com.netease.shopping.dao.mapper;

import com.netease.shopping.entity.Commodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuanchuang on 2018-3-8.
 */
@Repository
public interface CommodityMapper {

    public Integer insertCommodity(Commodity commodity);

    public Integer deleteCommodityById(int commodityID);

    public Commodity findById(int commodityID);

    public Integer updateCommodity(Commodity commodity);

    public List<Commodity> selectAll();

    /**
     * 多参数使用注解，在买家购买后，在商品表中更新数目
     * @param id
     * @param amount
     */
    public void updateAmount(@Param("id") Integer id , @Param("amount") Integer amount);

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

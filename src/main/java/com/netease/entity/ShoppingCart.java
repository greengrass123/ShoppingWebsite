package com.netease.entity;

import java.sql.Timestamp;

/**
 * Created by yuanchuang on 2018-3-12.
 */
public class ShoppingCart {
    private int id;
    private double price;//价格
    private int amount;//数量
    private int commodityID;//商品ID
    private Timestamp buy_time;//购买时间

    public ShoppingCart() {
    }

    public ShoppingCart(double price, int amount, int commodityID) {
        this.price = price;
        this.amount = amount;
        this.commodityID = commodityID;
        Timestamp buy_time=new Timestamp(System.currentTimeMillis());
        this.buy_time=buy_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }

    public Timestamp getBuy_time() {
        return buy_time;
    }

    public void setBuy_time(Timestamp buy_time) {
        this.buy_time = buy_time;
    }
}

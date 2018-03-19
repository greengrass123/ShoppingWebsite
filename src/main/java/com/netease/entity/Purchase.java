package com.netease.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

/**
 * Created by yuanchuang on 2018-3-12.
 */
public class Purchase {
    private int id;
    private double price;//价格，可能与商品最后价格不一致
    private int amount;//数量
    private int commodityID;//商品ID
    private Timestamp payment_time;//付款时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp buy_time;//买商品的时间

    public Purchase() {
    }

    public Purchase(double price, int amount, int commodityID, Timestamp buy_time) {
        this.price = price;
        this.amount = amount;
        this.commodityID = commodityID;
        this.buy_time=buy_time;
        Timestamp paymentTime = new Timestamp(System.currentTimeMillis());
        this.payment_time=paymentTime;
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

    public void setCommodityID(int commodityId) {
        this.commodityID = commodityId;
    }

    public Timestamp getPaymentTime() {
        return payment_time;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.payment_time = paymentTime;
    }

    public Timestamp getBuy_time() {
        return buy_time;
    }

    public void setBuy_time(Timestamp buy_time) {
        this.buy_time = buy_time;
    }
}

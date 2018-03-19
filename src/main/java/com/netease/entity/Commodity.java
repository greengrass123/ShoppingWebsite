package com.netease.entity;

/**
 * Created by yuanchuang on 2018-3-8.
 */

import java.sql.Timestamp;

/**
 * 商品类
 */
public class Commodity {
    private int id;
    private String title;//标题
    private String summary;//摘要
    private String imgUrl;//图片的url
    private int image_source;//图片来源，网络图片为1，还本地上传图片为2
    private String text;//正文
    private double price;//价格
    private Integer amount;//购买数量
    private Timestamp publishTime;//发布时间
    private int userID;//发布者

    public Commodity() {
    }

    public Commodity(String title, String summary, String imgUrl,int image_source, String text, double price, int amount) {
        this.title = title;
        this.summary = summary;
        this.imgUrl = imgUrl;
        this.image_source=image_source;
        this.text = text;
        this.price = price;
        this.amount=amount;
        Timestamp publishTime = new Timestamp(System.currentTimeMillis());
        this.publishTime=publishTime;
    }

    public Commodity(int id,String title, String summary, String imgUrl,int image_source, String text, double price) {
        this.id=id;
        this.title = title;
        this.summary = summary;
        this.imgUrl = imgUrl;
        this.image_source=image_source;
        this.text = text;
        this.price = price;
        Timestamp publishTime = new Timestamp(System.currentTimeMillis());
        this.publishTime=publishTime;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getImage_source() {
        return image_source;
    }

    public void setImage_source(int image_source) {
        this.image_source = image_source;
    }
}

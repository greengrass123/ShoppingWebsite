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
    private String text;//正文
    private int price;//价格
    private Timestamp publishTime;//发布时间
    private int userID;//发布者

    public Commodity(String title, String summary, String imgUrl, String text, int price) {
        this.title = title;
        this.summary = summary;
        this.imgUrl = imgUrl;
        this.text = text;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
}

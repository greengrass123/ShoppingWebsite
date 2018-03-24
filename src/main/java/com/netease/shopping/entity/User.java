package com.netease.shopping.entity;

/**
 * Created by yuanchuang on 2018-2-25.
 */
public class User {
    private Integer id;
    private String userName;//用户名
    private String password;//用户密码
    private Integer type;//用户类别，卖家和买家

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

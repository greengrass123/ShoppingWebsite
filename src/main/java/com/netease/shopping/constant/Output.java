package com.netease.shopping.constant;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * Created by yuanchuang on 2018-3-31.
 * 设计的返回格式，项目中暂时没有使用
 */
public class Output {
    /**
     * 返回客户端统一格式，包括状态码，提示信息，以及业务数据
     */
    private static final long serialVersionUID = 1L;
    //状态码
    private int statusCode;
    //必要的提示信息
    private String message;
    //业务数据
    private Object data;

    public Output(int status,String message,Object data){
        this.statusCode = status;
        this.message = message;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String toString(){
        if(null == this.data){
            this.setData(new Object());
        }
        return JSONUtils.toJSONString(this);
    }
}

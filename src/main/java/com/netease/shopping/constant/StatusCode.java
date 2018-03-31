package com.netease.shopping.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanchuang on 2018-3-8.
 */
public class StatusCode {

    public static Map<String,String> messageMap = new HashMap<String, String>();
    //*********************返回异常吗

    //所有异常
    public static final int ER10=10;

    //运行时异常
    public static final int ER100=100;

    //空指针异常
    public static final int ER101=101;

    //类型转换异常
    public static final int ER102=102;

    //IO异常
    public static final int ER103=103;

    //未知方法异常
    public static final int ER104=104;

    //数组越界异常
    public static final int ER105=105;

    //上传文件过大
    public static final int ER106=106;



    //400错误
    public static final int ER400=400;
    //405错误
    public static final int ER405=405;
    //406错误
    public static final int ER406=406;

    //500错误
    public static final int ER500=500;

    //*********************


    /**
     * 成功码
     */
    public static final int S1000 = 1000;

    /**
     * 登录状态吗，表示无此用户
     */
    public static final int S2001=2001;
    /**
     * 登录状态吗，表示密码错误
     */
    public static final int S2002=2002;
    /**
     * 非法参数错误，即调用参数不合法
     */
    public static final int ER5001 = 5001;

    /**
     * 数据库删除或更新失败
     */
    public static final int ER6001 = 6001;

    /**
     * 不是我们想要的文件类型,请按要求重新上传
     */
    public static final String ER7001="7001";

    /**
     * 文件类型为空
     */
    public static final String ER7002="7002";


    static {
        messageMap.put("400", "Bad Request!");
        messageMap.put("401", "NotAuthorization");
        messageMap.put("405", "Method Not Allowed");
        messageMap.put("406", "Not Acceptable");
        messageMap.put("500", "Internal Server Error");
        messageMap.put("10", "发生错误");
        messageMap.put("100", "[服务器]运行时异常");
        messageMap.put("101", "[服务器]空值异常");
        messageMap.put("102", "[服务器]数据类型转换异常");
        messageMap.put("103", "[服务器]IO异常");
        messageMap.put("104", "[服务器]未知方法异常");
        messageMap.put("105", "[服务器]数组越界异常");
        messageMap.put("106", "上传文件过大");

        messageMap.put("2001", "用户未注册");
        messageMap.put("2002", "密码错误");


        messageMap.put("5001", "参数不合法");
        messageMap.put("6001", "数据库删除或更新失败");
    }
}

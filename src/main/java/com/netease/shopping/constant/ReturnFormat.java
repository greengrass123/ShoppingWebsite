package com.netease.shopping.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanchuang on 2018-3-31.
 * 设计的返回码和内容，没有使用
 */
public class ReturnFormat {
    private static Map<String,String> messageMap = new HashMap<String, String>();
    //初始化状态码与文字说明
    static {
        messageMap.put("0", "");
        messageMap.put("400", "Bad Request!");
        messageMap.put("401", "NotAuthorization");
        messageMap.put("405", "Method Not Allowed");
        messageMap.put("406", "Not Acceptable");
        messageMap.put("500", "Internal Server Error");

        messageMap.put("100", "[服务器]运行时异常");
        messageMap.put("101", "[服务器]空值异常");
        messageMap.put("102", "[服务器]数据类型转换异常");
        messageMap.put("103", "[服务器]IO异常");
        messageMap.put("104", "[服务器]未知方法异常");
        messageMap.put("105", "[服务器]数组越界异常");
        messageMap.put("106", "[服务器]网络异常");

        messageMap.put("2001", "用户未注册");
        messageMap.put("2002", "密码错误");

        messageMap.put("1030", "周边无店铺");
        messageMap.put("1031", "店铺添加失败");
        messageMap.put("1032", "编辑店铺信息失败");
        messageMap.put("1033", "每个用户只能添加一个商铺");
        messageMap.put("1034", "店铺不存在");
        messageMap.put("1040", "无浏览商品");
        messageMap.put("1041", "添加失败,商品种类超出上限");
        messageMap.put("1042", "商品不存在");
        messageMap.put("1043", "商品删除失败");

        messageMap.put("5001", "参数不合法");
    }
    public static String retParam(int status,Object data) {
        Output output = new Output(status, messageMap.get(String.valueOf(status)), data);
        return output.toString();
    }
}

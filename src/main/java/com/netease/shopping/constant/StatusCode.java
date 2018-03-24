package com.netease.shopping.constant;

/**
 * Created by yuanchuang on 2018-3-8.
 */
public class StatusCode {
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
}

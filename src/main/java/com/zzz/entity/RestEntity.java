package com.zzz.entity;

import java.io.Serializable;

public class RestEntity<T> implements Serializable {
    /**
     * 错误代码
     */
    private static final int SUCCESS = 0; // 成功
    private static final int CHECK_FAIL = 1; // 失败
    private static final int UNKNOWN_EXCEPTION  = -99; // 抛出异常
    /**
     * 接口返回状态码，0表示成功，其他的看对应定义
     *
     * 推荐：
     * 0  ： 表示成功
     * >0 :  表示已知的异常（需要在调用的地方单独处理）
     * <0 :  表示未知的异常（不需要单独处理，调用方统一处理）
     */
    private int code = SUCCESS; // 返回状态

    /**
     * 返回信息（出错的时候使用）
     */
    private String msg = "success";

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 请求正确（新增、修改、删除信息），返回调用
     */
    public RestEntity() {
        super();
    }

    /**
     * 请求数据正确，返回调用
     * @param data 返回数据
     */
    public RestEntity(T data) {
        super();
        this.data = data;
    }

    /**
     * 请求出错，返回调用
     * @param msg 错误提醒语句
     */
    public RestEntity(String msg) {
        this.code = CHECK_FAIL;
        this.msg = msg;
    }

    /**
     * 请求异常，返回调用
     * @param e 异常
     */
    public RestEntity(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = UNKNOWN_EXCEPTION;
    }


    public static int getSUCCESS() {
        return SUCCESS;
    }

    public static int getCheckFail() {
        return CHECK_FAIL;
    }

    public static int getUnknownException() {
        return UNKNOWN_EXCEPTION;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

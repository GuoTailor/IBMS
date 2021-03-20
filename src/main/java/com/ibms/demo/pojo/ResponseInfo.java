package com.ibms.demo.pojo;

/**
 * Created by gyh on 2021/2/4
 */
public class ResponseInfo<T> {
    public static final int OK_CODE = 0;
    public static final int FAILED_CODE = 1;
    public int code;
    public String msg;
    public T data;

    public ResponseInfo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseInfo() {
    }

    public static <T> ResponseInfo<T> ok() {
        return new ResponseInfo<T>(OK_CODE, "成功");
    }

    public static <T> ResponseInfo<T> ok(String msg, T data) {
        return new ResponseInfo<T>(OK_CODE, msg, data);
    }

    public static <T> ResponseInfo<T> ok(T data) {
        return new ResponseInfo<T>(OK_CODE, "成功", data);
    }

    public static <T> ResponseInfo<T> failed() {
        return new ResponseInfo<T>(FAILED_CODE, "失败");
    }

    public static <T> ResponseInfo<T> failed(String msg) {
        return new ResponseInfo<T>(FAILED_CODE, msg);
    }

    public static <T> ResponseInfo<T> failed(String msg, T data) {
        return new ResponseInfo<T>(FAILED_CODE, msg, data);
    }
}

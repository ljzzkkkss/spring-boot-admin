package com.admin.utils;

public class Result {
    private String code;
    private Object data;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(String code, String message){
        this.code = code;
        this.message = message;
    }
    public Result(String code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(Object data){
        this.code = "0000";
        this.data = data;
    }
}

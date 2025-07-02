package com.mo.mobabmo.global.response;

public class CommonResponse<T> {
    private String msg;
    private T data;

    public CommonResponse(String msg, T data){
        this.msg = msg;
        this.data = data;
    }
}

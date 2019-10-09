package com.wind.springbootlearn2.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonData implements Serializable {

    private int code;
    private Object data;
    private String msg;

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}

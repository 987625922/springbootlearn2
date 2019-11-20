package com.wind.springbootlearn2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/*
*  controller的api输出的测试类
* */
@Getter
@Setter
public class UserControllerBean {
    public UserControllerBean(int age, String pwd, String phone, Date date) {
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.date = date;
    }

    private int age;
    @JsonIgnore
    private String pwd;
    @JsonProperty("uPhone")
    private String phone;
    @JsonFormat(pattern = "yyy-mm-dd hh:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date date;

}

package com.wind.springbootlearn2.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private int id;

    private String name;

    private String phone;

    private int age;

    private Date createTime;

}

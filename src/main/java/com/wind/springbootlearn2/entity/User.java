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

    public User() {
    }

    public User(int id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }
}

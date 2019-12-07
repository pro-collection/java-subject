package com.mybatis.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String created;
    private String updated;
}

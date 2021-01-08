package com.geek.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author Robert
 * @create 2020/12/22 10:00
 * @Version 1.0
 */

@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;

}

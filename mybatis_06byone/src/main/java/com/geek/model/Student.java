package com.geek.model;

import lombok.Data;

/**
 * @Author Robert
 * @create 2020/12/21 16:10
 * @Version 1.0
 */

@Data
public class Student {

    private int id;
    private String name;
    private int tid;

//    关联teacher
//    private Teacher teacher;
}

package com.geek.model;

import lombok.Data;

import java.util.List;

/**
 * @Author Robert
 * @create 2020/12/21 16:11
 * @Version 1.0
 */

@Data
public class Teacher {
    private int id;
    private String name;

//    关联学生集合
    private List<Student> students;
}

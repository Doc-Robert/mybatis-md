package com.geek.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Robert
 * @create 2020/12/22 16:09
 * @Version 1.0
 */

@Data
public class User implements Serializable {

    private int id;
    private String name;
    private String password;
}

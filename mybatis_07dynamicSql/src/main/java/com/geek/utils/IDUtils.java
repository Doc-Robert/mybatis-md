package com.geek.utils;

import java.util.UUID;

/**
 * @Author Robert
 * @create 2020/12/22 11:03
 * @Version 1.0
 */
public class IDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");

    }
}

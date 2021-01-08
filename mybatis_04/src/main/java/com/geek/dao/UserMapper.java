package com.geek.dao;

import com.geek.model.User;

import java.util.List;
import java.util.Map;

/**
 * @Author Robert
 * @create 2020/12/21 8:49
 * @Version 1.0
 */
public interface UserMapper {
    User getEmpById(Integer id);
    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

}

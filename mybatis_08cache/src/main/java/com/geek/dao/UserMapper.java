package com.geek.dao;

import com.geek.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Robert
 * @create 2020/12/22 16:10
 * @Version 1.0
 */
public interface UserMapper {
    //根据id 查询用户
    User selectUserById(@Param("id") int id);

}

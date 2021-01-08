package com.geek.dao;

import com.geek.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Author Robert
 * @create 2020/12/21 8:49
 * @Version 1.0
 */
public interface UserMapper {

    //方法存在多个参数，所有的参数前面必须加上@Param（“id”）注解
    @Select("select * from mybatis_tb1 where id=#{id}")
    User getUserById(@Param("id") Integer id);


    List<User> getUserByLimit(Map<String,Integer> map);

    @Select("select * from mybatis_tb1")
    List<User> getUsers();

    @Insert("insert into mybatis_tb1(id,last_name,password,gender,email) values (#{id},#{lastName},#{password},#{gender},#{email})")
    int addUser(User user);

    @Update("update mybatis_tb1 set last_name=#{lastName},password=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from mybatis_tb1 where id = #{id}")
    int deleteUser(@Param("id") int id);


}

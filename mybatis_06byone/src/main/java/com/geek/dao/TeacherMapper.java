package com.geek.dao;

import com.geek.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Robert
 * @create 2020/12/21 16:13
 * @Version 1.0
 */
public interface TeacherMapper {

//    @Select("select * from teacher where id=#{tid}")
//    Teacher getTeacher(@Param("tid") int id);

//    List<Teacher> getTeacher();
    Teacher getTeacher(@Param("tid") int id);
    Teacher getTeacher2(@Param("tid") int id);
}

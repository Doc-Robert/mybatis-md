package com.geek.mybatis_01_hello.dao;

import com.geek.mybatis_01_hello.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author user
 * @create 2020/11/18 16:15
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmp(Integer i);

    Employee getEmpByIdAndLastName(@Param("id")Integer id, @Param("lastName")String lastName);

    Employee getEmpByMap(Map<String, Object> map);
}




/*
      Employee getEmpByIdAndLastName //多个参数下的 mybatis 传值
      --命名参数； 明确指定封装参数时的map的key ； @Param("id")
            多个参数会被封装为一个map
            key：使用@Param注解指定的值
            value:参数值
        #{指定的key} 来取出对应的参数值

    pojo：
        如果多个参数正好是业务逻辑的数据模型，我们可以直接传入pojo
            #{属性名}；取出传入的pojo属性值
    Map:
        如果多个参数不是业务模型中的数据，没有对应的pojo，为了方便，我们也可以传入map
        #{key}；取出map中对应的值

    TO：
        如果多个参数不是业务模型中的数据，但是经常要用，推荐编写一个TO（Transfer Object）数据传输对象
        page{
            int xxxx；
            int xxx;

        }
*/





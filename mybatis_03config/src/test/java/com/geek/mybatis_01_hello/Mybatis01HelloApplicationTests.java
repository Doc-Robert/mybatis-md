package com.geek.mybatis_01_hello;

import com.geek.mybatis_01_hello.dao.EmployeeMapper;
import com.geek.mybatis_01_hello.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Mybatis01HelloApplicationTests {

    /**
     * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     * 2.sql映射文件：配置每一个sql，及sql封装规则
     * 3.将sql映射文件注册总在全局配置文件中
     * 4.代码
     *  1）、根据全局配置文件得到SqlSessionFactory
     *  2)、使用SqlSessionFactory，获取SqlSession对象执行增删查改
     *      一个SqlSession就是与数据库的一次对话，完毕即close
     *  3)、使用sql唯一标识来告诉mybatis执行哪个sql。sql都保存在映射文件中
     * @throws IOException
     */
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-conf.xml";//根据全局配置文件 的路径
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    void contextLoads() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        //2、获取SqlSession实例，能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //传入唯一标识id 和一个参数
            Employee employee = openSession.selectOne("Employee.selectEmp",1 );
            System.out.println(employee);
        }finally {
            openSession.close();
        }

    }
    public void test01() throws IOException {
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

         //2.获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            //3.获取接口的实现对象
            EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);
            //调用接口方法
            Employee employee = employeeMapper.getEmpById(1);
            //打印调用方法
            System.out.println(employeeMapper.getClass());
            System.out.println(employee);
        }finally {
            //关闭会话
            openSession.close();
        }

    }

    /**
     *  crud test
     *  1.mybatis允许crud直接定义以下类型返回值
     *      Integer Boolean Long
     *  2.需要手动提交数据
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {

        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlSession对象  默认不带参数的 不会自动提交数据
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Employee employee = mapper.getEmpById(1);

            System.out.println(employee);

            //通过传输多个值
//            Employee employee01 = mapper.getEmpByIdAndLastName(1,"Reines");

//            Employee employee02 = new Employee(1,"Reines","123.cc","1");
//            mapper.updateEmp(employee02);

//            Employee employee03 = mapper.getEmpById(1);

            //通过map来传输数据
//            Map<String, Object> map = new HashMap<>();
//            map.put("id",2);
//            map.put("lastName","linns");
//            Employee employee = mapper.getEmpByMap(map);
//
//            System.out.println(employee);
//            System.out.println(employee03);

//            System.out.println(employee01);

            //手动提交
//            Employee employee = new Employee(1,"linns","123.cc","1");
            //添加
//            mapper.addEmp(employee);
            //修改
//            mapper.updateEmp(employee);

            //手动提交数据
//            openSession.commit();
        }finally {
            openSession.close();
        }
    }


}

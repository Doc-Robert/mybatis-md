package com.geek;

import com.geek.dao.UserMapper;
import com.geek.model.User;


import com.geek.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;


@SpringBootTest
class Mybatis04ApplicationTests {

    static Logger logger = Logger.getLogger(Mybatis04ApplicationTests.class);

    @Test
    public void getUsers(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUsers();
//        User users = mapper.getUserById(1);
        mapper.getUsers();
        mapper.addUser(new User(4, "1", "123213","123","1234"));
        mapper.updateUser(new User(2, "3", "222", "111", "1234566"));
        mapper.deleteUser(4);
//        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test(){
//        SqlSession openSession = MyBatisUtils.getSqlSession();
        logger.info("info:进入log4j");
        logger.debug("debug:进入log4j");
        logger.error("error:进入log4j");

    }

    @Test
    void contextLoads(){

        SqlSession openSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = openSession.getMapper(UserMapper.class);

//        User user = mapper.getEmpById(1);

//        System.out.println(user);

        openSession.close();

    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",2);

        List<User> userList= mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

    }
}

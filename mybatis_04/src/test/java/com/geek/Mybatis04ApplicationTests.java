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

        User user = mapper.getEmpById(1);

        System.out.println(user);

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

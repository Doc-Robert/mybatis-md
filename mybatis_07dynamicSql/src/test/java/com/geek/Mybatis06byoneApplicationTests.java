package com.geek;

import com.geek.dao.BlogMapper;
import com.geek.model.Blog;
import com.geek.utils.IDUtils;
import com.geek.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class Mybatis06byoneApplicationTests {

    @Test
    public void addBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getUUID());
        blog.setTitle("El-melou");
        blog.setAuthor("Reines");
        blog.setCreateTime(new Date());
        blog.setViews(777);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        mapper.addBlog(blog);

        blog.setId(IDUtils.getUUID());
        mapper.addBlog(blog);

        sqlSession.close();

    }

    @Test
    public void selectBlogIF(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
//        hashMap.put("title","El-melou2");
        hashMap.put("author","waybo");
        hashMap.put("id","1");
//        mapper.updateBlog(hashMap);
//        System.out.println("over");
//        for (Blog blog : blogs) {
//            System.out.println(blog);
//        }
//        hashMap.put("title","El-melou");

//        List<Blog> blogs = mapper.selectBlogWhere(hashMap);
//        for (Blog blog : blogs) {
//            System.out.println(blog);
//        }
        sqlSession.close();

    }

    @Test
    public void selectBlogForeach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        hashMap.put("ids",ids);

        List<Blog> blogs = mapper.selectBlogForeach(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();

    }
}

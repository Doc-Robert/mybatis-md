package com.geek.dao;

import com.geek.model.Blog;

import java.util.List;
import java.util.Map;

/**
 * @Author Robert
 * @create 2020/12/22 10:59
 * @Version 1.0
 */
public interface BlogMapper {

    //添加
    void addBlog(Blog blog);
    //查询
    List<Blog> selectBlogIF(Map map);
    List<Blog> selectBlogWhere(Map map);
    List<Blog> selectBlogChoose(Map map);
    //update
    int updateBlog(Map map);

    List<Blog> selectBlogForeach(Map map);

}

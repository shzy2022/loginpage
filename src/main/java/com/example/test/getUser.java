package com.example.test;


import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class getUser {
    public static void main(String[] args) {
        SqlSession session = GetSqlSession.createSqlSession();
//        User user = session.selectOne("com.example.mapper.UserMapper.queryUserByName","张三");
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName("李四");

        System.out.println(user);
    }

}

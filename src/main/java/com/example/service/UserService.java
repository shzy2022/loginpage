package com.example.service;

import com.example.entity.User;
import com.example.entity.model.MessageModel;
import com.example.mapper.UserMapper;
import com.example.util.GetSqlSession;
import com.example.util.strIsEmpty;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public MessageModel userLogin(String name, String pwd) {

        MessageModel model = new MessageModel();

        User user = new User();
        user.setName(name);
        user.setPassword(pwd);
        model.setObject(user);


        if(strIsEmpty.isEmpty(name)||strIsEmpty.isEmpty(pwd)){
            model.setMsg("姓名或密码不可为空！");
            return model;
        }

        //查询用户
        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User u = userMapper.queryUserByName(name);

        if(u == null){
            model.setMsg("用户不存在");
            return model;
        }

        if(!pwd.equals( u.getPassword())){
            model.setMsg("用户密码不正确");
            return model;
        }

        model.setMsg("登录成功");
        model.setCode(1);
        model.setObject(u);
        return model;
    }
}

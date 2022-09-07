package com.example.controller;

import com.example.entity.model.MessageModel;
import com.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name);
        System.out.println(pwd);

        MessageModel model = userService.userLogin(name,pwd);
        req.getSession().setAttribute("model",model);

        if(model.getCode()==1){
//            成功
            req.getSession().setAttribute("user",model.getObject());
            resp.sendRedirect("index.jsp");
        }else {
            req.getSession().setAttribute("messageModel",model);
            req.getRequestDispatcher("login.jsp").forward(req,resp);

        }
    }
}

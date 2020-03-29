package com.miaoshaproject.controller;


import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("/qqq")
@RequestMapping("/qqq")
public class SessionTest {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/a",method = {RequestMethod.GET})
    @ResponseBody
    public void test() throws IOException {
        String username = "lisi";
        request.setAttribute("user", username);
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        System.out.println("/a session:"+session);
        String uri = "/qqq/b";
        uri = response.encodeRedirectURL(uri);
        response.sendRedirect(uri);
    }

    @RequestMapping(value = "/b",method = {RequestMethod.GET})
    @ResponseBody
    public void getCookieName() throws IOException {
        String str = "";
        //从request域中读取属性
        str = request.getParameter("user");
        //获取session
        HttpSession session = request.getSession(false);
        System.out.println("/b session:"+session);
        String username = "";
        //从Session域中读取指定属性
        if(session != null){
            username = (String) session.getAttribute("username");
        }
        response.getWriter().println("user:"+str);
        response.getWriter().println("username:"+username);
        response.getWriter().println("session:"+session);

    }
}

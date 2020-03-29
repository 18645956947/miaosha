package com.miaoshaproject.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        //创建两个cookie
        Cookie cookie1 = new Cookie("zhx", "oneToThree");
        Cookie cookie2 = new Cookie("qx", "nihaoa");

        response.addCookie(cookie1);
        response.addCookie(cookie2);

    }
}

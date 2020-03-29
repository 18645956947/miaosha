package com.miaoshaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("/qwe")
@RequestMapping("/qwe")
public class CookieTest {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/asd",method = {RequestMethod.GET})
    @ResponseBody
    public String test(){
        //创建两个cookie
        Cookie cookie1 = new Cookie("teacher", "oneToThree");
        Cookie cookie2 = new Cookie("worker_niudun", "nihaoa");
        //指定cookie的资源路径
        cookie1.setPath(request.getContextPath() + "/xxx/eee");
        cookie2.setPath(request.getContextPath() + "/ggg");
        //设置cookie有消息为10天
        cookie1.setMaxAge(60 * 60 * 24 * 10);
        System.out.println("地址为："+request.getContextPath());
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "你好啊";
    }

    @RequestMapping(value = "/asd/q",method = {RequestMethod.GET})
    @ResponseBody
    public void getCookieName(){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            System.out.println(cookie.getName());
        }
    }
}

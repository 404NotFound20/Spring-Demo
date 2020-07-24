package com.example.springtest.controller;

import com.example.springtest.chapter3.config.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 创建一个 ThymeleafController 用来映射HTTP请求与页面的跳转
 * @Author: 80156962
 * @Date: 2020/7/2
 */
@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        // 设置属性
        view.addObject("title", "这是标题");
        view.addObject("desc", "这是标题描述");
        User user = new User();
        user.setId(22L);
        user.setNote("1837307557@qq.com");
        user.setUserName("唐亚峰");
        view.addObject("User", user);
        return view;
    }
}

package com.example.springtest.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/6/15
 */
@RestController
//启用Spring Boot自动装配
@EnableAutoConfiguration
@RequestMapping(value = "/demo")
public class DemoCountroller {

    @GetMapping("/echo")
    public Map<String,String> echo() {
        Map<String,String>map=new HashMap<String ,String>();
        map.put("key","value");
        return map;
    }
}

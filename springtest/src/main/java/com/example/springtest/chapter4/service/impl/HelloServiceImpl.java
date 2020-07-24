package com.example.springtest.chapter4.service.impl;

import com.example.springtest.chapter4.service.HalloService;

import java.sql.SQLOutput;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/13
 */
public class HelloServiceImpl implements HalloService {
    @Override
    public void sayHallo(String name){
        if (name==null||name.trim().equals("")){
            throw new RuntimeException("参数错误");
        }
        System.out.println("hello"+name);
    }
}

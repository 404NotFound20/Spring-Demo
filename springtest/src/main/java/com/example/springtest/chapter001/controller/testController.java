package com.example.springtest.chapter001.controller;

import com.example.springtest.chapter001.service.RiskUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/15
 */
@RestController
//启用Spring Boot自动装配
@EnableAutoConfiguration
@RequestMapping(value = "/test")
public class testController {
    @Autowired
    RiskUserDataService riskUserDataService;
    @PostMapping(value = "/sql", produces = "application/json;charset=UTF-8")
    public String sql(String userId,String evn) {
        return riskUserDataService.queryUserInformation(userId,evn);
    }
}

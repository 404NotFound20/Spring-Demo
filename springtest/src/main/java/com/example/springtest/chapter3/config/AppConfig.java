package com.example.springtest.chapter3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 定义java配置文件
 * @Author: 80156962
 * @Date: 2020/6/24
 */
@Configuration
public class AppConfig {
    @Bean(name="User")
    public User initUser() {
        User user = new User();
        user.setId(2076070203L);
        user.setUserName("张三");
        user.setNote("笔记");
        return user;
    }
}

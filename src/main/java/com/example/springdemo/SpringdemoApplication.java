package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @SpringBootApplication 标注主程序类
 * @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})  暂时忽略数据库配置
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SpringdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

}

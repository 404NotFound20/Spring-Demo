package com.example.springtest.chapter3.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:测试Ioc容器 代码中将 Java 配置文件 AppConfig 传递给 AnnotationConfigApp li cationContext 的构造方法，这
 * 样它就能够读取配置了。然后将配置里面的 Bean 装配到 IoC 容器中，于是可以使用 getBean 方法获
 * 取对应的 POJO ，你可 以看到下面的日志打印
13:13:12.492 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'appConfig'
13:13:12.495 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'User'
13:13:12.516 [main] INFO com.example.springtest.chapter3.config.IoCTest - 张三--笔记--2076070203
 * @Author: 80156962
 * @Date: 2020/6/28
 */
public class IoCTest {
    private static Logger log = LoggerFactory.getLogger(IoCTest.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        log.info(user.getUserName()
                + "--" + user.getNote()
                + "--" + user.getId());

    }

}

package com.example.springtest;

import com.example.springtest.chapter4.intercept.MyInterceptor;
import com.example.springtest.chapter4.proxy.ProxyBean;
import com.example.springtest.chapter4.service.HalloService;
import com.example.springtest.chapter4.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/14
 */
@SpringBootTest
public class testProxy {
    Logger log = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        HalloService halloService=new HelloServiceImpl();
        HalloService proxy=(HalloService) ProxyBean.getProxyBean(halloService,new MyInterceptor());
        proxy.sayHallo("hello hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        log.info("hallo is  null-------------------");
        proxy.sayHallo(null);
        log.info("info");
    }
}

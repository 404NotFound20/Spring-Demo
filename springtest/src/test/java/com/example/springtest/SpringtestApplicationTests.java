package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringtestApplicationTests {
    Logger log = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        log.debug("debug 日志");
        log.info("info 日志");
    }

}

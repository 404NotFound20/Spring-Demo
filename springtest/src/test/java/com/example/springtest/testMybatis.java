package com.example.springtest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/15
 */
@SpringBootTest

public class testMybatis {
    @Test
    void MybatisCount() {
    String resourcePath = "smybatis/mybatis-config.xml";
        SqlSession sqlSession=null;
        int count=0;
        try{
            InputStream is = Resources.getResourceAsStream(resourcePath);
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
            sqlSession=sqlSessionFactory.openSession();
            count=sqlSession.selectOne("com.example.springtest.chapter001.mapper.UserGroupMapper");
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(count);
    }

}

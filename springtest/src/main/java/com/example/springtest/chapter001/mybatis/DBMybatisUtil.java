package com.example.springtest.chapter001.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.pkcs11.Secmod;

import javax.sql.CommonDataSource;
import java.io.IOException;
import java.io.Reader;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/15
 */
public class DBMybatisUtil {
    private static final Logger log = LoggerFactory.getLogger(DBMybatisUtil.class);
    private static SqlSessionFactory sqlSessionFactory;
    //mybatis配置读取地址
    private static String resourcePath = "mybatis/mybatis-config.xml";

    public  static SqlSessionFactory getSqlsessionfactory(String environment) {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(DBMybatisUtil.resourcePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        log.info("Get {} SqlSessionFactory successfully.", environment);
//        String environment = CommongetDevelopmentEnvironment();
//        environment = environment.equals("dev") || environment.equals("") ? "development" : environment;
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, environment);
        return sqlSessionFactory;
    }


    public  static SqlSession createSqlSession(String evn) {
        SqlSessionFactory sqlSessionFactory= DBMybatisUtil.getSqlsessionfactory(evn);
        return sqlSessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
            log.info("commit.");
        }
    }

}

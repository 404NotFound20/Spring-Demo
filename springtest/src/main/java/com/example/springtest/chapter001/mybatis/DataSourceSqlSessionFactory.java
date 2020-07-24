package com.example.springtest.chapter001.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.ObjectUtils;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/16
 */

public final class DataSourceSqlSessionFactory {
    private static final String CONFIGURATION_PATH = "mybatis/mybatis.xml";

    private static final Map<DataSourceEnvironment, SqlSessionFactory> SQLSESSIONFACTORYS
            = new HashMap<DataSourceEnvironment, SqlSessionFactory>();

    /**
     * 根据指定的DataSourceEnvironment获取对应的SqlSessionFactory
     *
     * @param environment 数据源environment
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory(DataSourceEnvironment environment) {

        SqlSessionFactory sqlSessionFactory = SQLSESSIONFACTORYS.get(environment);
        if (!ObjectUtils.isEmpty(sqlSessionFactory))
            return sqlSessionFactory;
        else {
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(CONFIGURATION_PATH);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environment.name());

                System.out.println("Get {} SqlSessionFactory successfully."+ environment.name());
            } catch (IOException e) {
                System.out.println("Get {} SqlSessionFactory error."+environment.name());
                System.out.println(e.getMessage());

            } finally {
                IOUtils.closeQuietly(inputStream);
            }

            SQLSESSIONFACTORYS.put(environment, sqlSessionFactory);
            return sqlSessionFactory;
        }
    }
    public static SqlSession createSqlSession() {
        return SQLSESSIONFACTORYS.get("sqlSessionFactory").openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    /**
     * 配置到Configuration.xml文件中的数据源的environment的枚举描述
     *
     * @author boyce
     * @version 2014-3-27
     */
    public static enum DataSourceEnvironment {
        TEST1,
        TEST2,
        TEST95;
    }
}


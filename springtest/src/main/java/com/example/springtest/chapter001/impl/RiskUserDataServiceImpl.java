package com.example.springtest.chapter001.impl;

import com.example.springtest.chapter001.dao.UserGroup;
import com.example.springtest.chapter001.mapper.UserGroupMapper;
import com.example.springtest.chapter001.mybatis.DBMybatisUtil;
import com.example.springtest.chapter001.service.RiskUserDataService;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/15
 */
@Service
public class RiskUserDataServiceImpl implements RiskUserDataService {
    Logger log = LoggerFactory.getLogger(getClass());

    @Override
    @Transactional
    public String queryUserInformation(String userId,String evn) {
        log.info("queryUserInformation  input"+userId);
        try (SqlSession session=DBMybatisUtil.createSqlSession(evn)) {
            // 假设下面三行代码是你的业务逻辑
            UserGroupMapper userGroupMapper=DBMybatisUtil.createSqlSession(evn).getMapper(UserGroupMapper.class);
            //注解查询userGroup
            String sqlRes = userGroupMapper.selectUserGroupByUserId(userId);
            log.info("queryUserInformation1  res:"+sqlRes);
            String sqlRes2 = userGroupMapper.selectUserIdByKey(18);
            log.info("queryUserInformation2  res:"+sqlRes2);
            //xml映射查询userGroup
            UserGroup userGroup=userGroupMapper.selectByPrimaryKey(18);
            DBMybatisUtil.closeSqlSession(session);
            log.info("queryUserInformation3  res:"+userGroup.getUserId());
            return sqlRes;
        }
    }
}

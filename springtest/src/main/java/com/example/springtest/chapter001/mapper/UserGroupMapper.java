package com.example.springtest.chapter001.mapper;

import com.example.springtest.chapter001.dao.UserGroup;
import org.apache.ibatis.annotations.Select;

public interface UserGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);

    @Select("select user_group from finance_risk.user_group where user_id=#{userid}")
    String selectUserGroupByUserId(String userid);

    @Select("select user_id from finance_risk.user_group where id=#{id}")
    String selectUserIdByKey(Integer id);
}
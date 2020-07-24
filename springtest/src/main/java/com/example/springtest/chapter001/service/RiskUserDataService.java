package com.example.springtest.chapter001.service;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/15
 */

public interface RiskUserDataService {
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public String  queryUserInformation(String userId,String evn);
}

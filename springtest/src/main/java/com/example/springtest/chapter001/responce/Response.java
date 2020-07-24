package com.example.springtest.chapter001.responce;

import jdk.nashorn.internal.codegen.ObjectClassGenerator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: 80156962
 * @Date: 2020/7/20
 */
public class Response<T> implements Serializable {
    public static final long serialVersionUID=2235152751651905167L;
    /**
     * 是否请求成功
     */
    private boolean success;
    /**
     * 返回码
     */
    private String resCode;
    /**
     * 返回描述
     */
    private String resMsg;
    /**
     * 错误信息
     */
    private String errorDetail;
    /**
     * 业务数据
     */
    private T data;
    private Map<Object, Object> map =new HashMap<>();

}

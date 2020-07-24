package com.example.springtest.chapter4.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 代理实现，以反射形式去调用原有方法
 * @Author: 80156962
 * @Date: 2020/7/13
 */
public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    public Invocation(Object[] params, Method method, Object target) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    //反射调用方法
    public Object proceed() throws
            InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }
}


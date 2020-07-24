package com.example.springtest.chapter4.intercept;

import com.example.springtest.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Description: 拦截器接口实现类
 * @Author: 80156962
 * @Date: 2020/7/13
 */
public class MyInterceptor implements Interceptor {

    @Override
    public boolean before() {
        System.out.println("事前方法");
        return true;
    }

    @Override
    public void after() {
        System.out.println("事后方法");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before ......");
        //这里调用原接口方法
        Object obj=invocation.proceed();
        System.out.println("around after ......");
        return null;
    }

    @Override
    public void afterReturning() {
        System.out.println("事件运行正常后");
    }

    @Override
    public void afterThrowing() {
        System.out.println("事件运行异常后");

    }

    @Override
    public boolean useAround() {
        return true;
    }
}

package com.example.springtest.chapter4.proxy;

import com.example.springtest.chapter4.intercept.Interceptor;
import com.example.springtest.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 实现roxyBean
 * @Author: 80156962
 * @Date: 2020/7/13
 */
public class ProxyBean implements InvocationHandler {
    private Object target = null;
    private Interceptor interceptor = null;

    /**
     * 绑定代理对象
     *要求 target 对象存在接口 ，而 interceptor 码清单 定义 接口对象
     * 那么它将返回 对象 们把 返回 对象 proxy 以使用 target 对象实现
     * 接口类型 它进行强制转换
     * @param target      被代理对象
     * @param interceptor 拦截器
     * @return 代理对象
     */
    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        //保存被代理对象
        proxyBean.target = target;
        //保存拦截器
        proxyBean.interceptor = interceptor;
        /*生成被代理对象
        * ClassLoader loader,类加载器
          Class<?>[] interfaces,绑定的接口
          InvocationHandler h) 绑定代理对象逻辑实现
          * */
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
        return proxy;
    }

    /**
     * 处理代理对象方法逻辑
     *
     * @param proxy  代理对象
     * @param method 当前方法
     * @param args   运行参数
     * @return 方法调用结果
     * @throws Throwable
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //异常标识
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation( args, method,target);
        Object retObj = null;
        try {
            if (this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }

        } catch (Exception ex) {
            //产生异常
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag){
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}

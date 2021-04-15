package com.hl.chapter13.demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理类
 */
public class AdminCglibServiceProxy implements MethodInterceptor {
    private Object target;

    public AdminCglibServiceProxy(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类代理对象
        return en.create();
    }

    public Object intercept(Object object, Method method, Object[] arg2, MethodProxy proxy) throws Throwable {

        System.out.println("-------------代理真实对象前自定义操作-----------------");
        Object obj = method.invoke(target);
        System.out.println("-------------代理真实对象后自定义操作-----------------");
        return obj;
    }

}

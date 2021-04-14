package com.hl.chapter11.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器实现类
 * 每次生成动态代理类对象时都需要指定一个实现了该接口的调用处理器对象
 */

public class MyInvocationHandler implements InvocationHandler {

    /**
     * 这个是我们代理的真实对象
     */
    private Object object;

    /**
     * 构造方法，给我们要代理的真实对象赋初值
     *
     * @param object
     */
    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    /**
     * 该方法负责集中处理动态代理类上的所有方法调用
     * 动态代理类根据这三个参数进行预处理或分派到委托类实例上反射执行
     *
     * @param proxy  代理类实例
     * @param method 被调用的方法对象
     * @param args   调用参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理真实对象前的自定义操作
        System.out.println("----------------代理真实对象前的自定义操作------------------");

        System.out.println("Method: " + method);

        // 当代理对象调用真实对象的方法时，其会自动跳转到代理对象关联的handler对象的invoke方法进行调用
        Object returnObject = method.invoke(object, args);

        // 代理真实对象后的自定义操作，此处为代理的最终目的
        System.out.println("---------------代理真实对象后自定义操作-----------------");
        return returnObject;
    }
}

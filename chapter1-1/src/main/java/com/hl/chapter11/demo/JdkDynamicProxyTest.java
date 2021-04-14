package com.hl.chapter11.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理演示
 */
public class JdkDynamicProxyTest {

    public static void main(String[] args) {
        // 代理的真实对象
        Target realTarget = new RealTarget();
        /**
         * MyInvocationHandler 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
         * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用.
         * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
         */
        InvocationHandler handler = new MyInvocationHandler(realTarget);
        // 获取类加载器
        ClassLoader classLoader = realTarget.getClass().getClassLoader();
        // 获取真实对象所实现的接口
        Class[] interfaces = realTarget.getClass().getInterfaces();
        /**
         * 该方法用户指定类加载器、一组接口、调用处理器来生成动态代理类实例
         */
        Target target = (Target) Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println("动态代理对象的类型：" + target.getClass().getName());
        String hello = target.SayHello("World");
        System.out.println(hello);
        String goodbye = target.SayGoodBye();
        System.out.println(goodbye);


    }
}

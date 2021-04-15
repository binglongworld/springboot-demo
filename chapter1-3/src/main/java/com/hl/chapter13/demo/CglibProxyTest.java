package com.hl.chapter13.demo;

/**
 * cglib动态代理测试类
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        // 被代理的真实类
        AdminCglibService target = new AdminCglibService();
        // cglib代理工厂类
        AdminCglibServiceProxy proxyFactory = new AdminCglibServiceProxy(target);
        // 代理类
        AdminCglibService proxy = (AdminCglibService) proxyFactory.getProxyInstance();
        // 打印代理类名称
        System.out.println("被代理对象名称：" + proxy.getClass().getName());
        // 通过代理类调用真实对象中的方法
        proxy.sayHello();
        proxy.sayGoodbye();
    }
}

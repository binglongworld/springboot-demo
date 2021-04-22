package com.hl.springbootdemo1.pattern.proxy;

/**
 * 静态测试类
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        AdminServiceProxy proxy = new AdminServiceProxy(adminService);
        proxy.update();
        System.out.println("========================================================");
        proxy.find();
    }
}

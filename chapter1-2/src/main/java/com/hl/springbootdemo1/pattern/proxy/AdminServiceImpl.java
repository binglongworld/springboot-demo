package com.hl.springbootdemo1.pattern.proxy;

/**
 * 实现类
 */
public class AdminServiceImpl implements AdminService {
    @Override
    public void update() {
        System.out.println("修改管理系统数据");
    }

    @Override
    public Object find() {
        System.out.println("查看管理系统数据");
        return new Object();
    }
}

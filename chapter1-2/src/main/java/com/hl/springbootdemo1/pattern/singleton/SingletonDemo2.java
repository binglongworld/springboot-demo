package com.hl.springbootdemo1.pattern.singleton;

/**
 * 懒汉式，线程不安全
 */
public class SingletonDemo2 {

    private static SingletonDemo2 instance = null;

    private SingletonDemo2() {

    }

    // 运行时加载对象
    public SingletonDemo2 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo2();
        }
        return instance;
    }
}

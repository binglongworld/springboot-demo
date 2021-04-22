package com.hl.springbootdemo1.pattern.singleton;

/**
 * 饿汉式，线程安全
 */
public class SingletonDemo1 {
    // 线程安全，类初始化时立即加载这个类
    private static SingletonDemo1 instance = new SingletonDemo1();

    private SingletonDemo1() {

    }

    // 方法没有加同步块，所以效率高
    public static SingletonDemo1 getInstance() {
        return instance;
    }
}

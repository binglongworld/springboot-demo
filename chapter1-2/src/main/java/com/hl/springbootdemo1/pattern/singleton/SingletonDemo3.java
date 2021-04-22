package com.hl.springbootdemo1.pattern.singleton;

/**
 * 懒汉式，双重同步锁
 */
public class SingletonDemo3 {
    private volatile static SingletonDemo3 instance = null;

    private SingletonDemo3() {

    }

    // 运行时加载对象
    public SingletonDemo3 getInstance() {
        synchronized (SingletonDemo3.class) {
            if (instance == null) {
                instance = new SingletonDemo3();
            }
        }

        return instance;
    }
}

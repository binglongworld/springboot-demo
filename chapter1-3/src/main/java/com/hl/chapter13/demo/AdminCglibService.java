package com.hl.chapter13.demo;

/**
 * 被代理的真实类
 */
public class AdminCglibService {
    public void sayHello() {
        System.out.println("Hello World");
    }

    public Object sayGoodbye() {
        System.out.println("Good Bye");
        return new Object();
    }
}

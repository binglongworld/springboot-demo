package com.hl.chapter11.demo;

/**
 * 需要动态代理的实际对象
 */
public class RealTarget implements Target {
    @Override
    public String SayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String SayGoodBye() {
        return "Good Bye";
    }
}

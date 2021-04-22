package com.hl.springbootdemo1.base;

/**
 * 测试hash算法
 */
public class TestHash {

    public static void main(String[] args) {
        generateHashCode(new String("Hello World"));
        generateHashCode(new A());
    }

    private static void generateHashCode(Object object) {
        int code = object.hashCode();
        System.out.println(object.getClass().getName() + " hash code: " + code);
    }

    // 静态内部类
    public static class A {

    }


}

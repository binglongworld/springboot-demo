package com.hl.springbootdemo1.base;

import java.util.Random;

public class Parent {
    Random random = new Random();
    private final static double PI = 3.14;
    private final Test test = new Test();
    private final int i = random.nextInt(20);
    private int i2 = random.nextInt(20);

    // 权限修饰符
    public String strPublic = "hello public";
    String strDefault = "hello default";
    protected String strProtected = "hello protected";
    private String strPrivate = "hello private";


    public static void main(String[] args) {
        Parent parent = new Parent();
//        parent.i = 10;
        System.out.println("parent.i2: " + parent.i2);
        parent.i2 = 99;
        System.out.println("parent.i2: " + parent.i2);
        System.out.println("parent.i: " + parent.i);
        System.out.println("parent.test.t: " + parent.test.t);
        parent.test.t = 20;
        System.out.println("parent.test.t: " + parent.test.t);

    }

    public void init() {
        System.out.println("Parent class");
    }

    public static void testFinal() {
        final double PI = 3.14;
        System.out.println(PI);
    }

    class Test {
        int t = 10;
    }
}

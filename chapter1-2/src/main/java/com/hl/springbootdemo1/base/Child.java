package com.hl.springbootdemo1.base;

public class Child extends Parent {

    public static void testFinal() {
        final double PI = 3.0;
        System.out.println(PI);
    }

    // 测试权限修饰符
    public void testModifier() {
        // 访问父类实例的成员变量
        Parent parent = new Parent();
        System.out.println(parent.strPublic);
        System.out.println(parent.strDefault);
        System.out.println(parent.strProtected);
        // 不能访问
//        System.out.println(parent.strPrivate);

        // 直接访问父类成员变量
        System.out.println(super.strPublic);
        System.out.println(super.strDefault);
        System.out.println(super.strProtected);
        // 不能访问
//        System.out.println(super.strPrivate);
    }

    public static void main(String[] args) {
//        Child child = new Child();
//        child.testFinal();

        // 测试权限修饰符
        new Child().testModifier();
    }
}

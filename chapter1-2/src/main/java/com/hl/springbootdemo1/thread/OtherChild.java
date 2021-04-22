package com.hl.springbootdemo1.thread;

import com.hl.springbootdemo1.base.Parent;

public class OtherChild extends Parent {
    // 测试权限修饰符(同包内非子类)
    public void testModifier() {
        // 访问父类实例的成员变量
        Parent parent = new Parent();
        System.out.println(parent.strPublic);
        // 不能访问
//        System.out.println(parent.strDefault);
        // 不能访问
//        System.out.println(parent.strProtected);
        // 不能访问
//        System.out.println(parent.strPrivate);

        // 直接访问父类成员变量
        System.out.println(super.strPublic);
        // 不能访问
//        System.out.println(super.strDefault);
        System.out.println(super.strProtected);
        // 不能访问
//        System.out.println(super.strPrivate);

    }

    public static void main(String[] args) {

        // 测试权限修饰符，不同包子类
        new OtherChild().testModifier();
    }
}

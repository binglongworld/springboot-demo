package com.hl.springbootdemo1.base;

public class NoChild {
    // 测试权限修饰符(同包内非子类)
    public void testModifier() {
        // 访问父类实例的成员变量
        Parent parent = new Parent();
        System.out.println(parent.strPublic);
        System.out.println(parent.strDefault);
        System.out.println(parent.strProtected);
        // 不能访问
//        System.out.println(parent.strPrivate);

    }

    public static void main(String[] args) {

        // 测试权限修饰符，同包非子类
        new NoChild().testModifier();
    }
}

package com.hl.springbootdemo1.base;

/**
 * 抽象类
 */
public class AbstractClass {
    abstract class Parent {
        public void parentHabits() {
            System.out.println("parent habits");
        }

        public abstract void childHabits();
    }

    class Child1 extends Parent {

        @Override
        public void childHabits() {
            System.out.println("child1 habits");
        }
    }

    class Child2 extends Parent {

        @Override
        public void childHabits() {
            System.out.println("child2 habits");
        }
    }

    public static void main(String[] args) {
        Parent child = new AbstractClass().new Child1();
        child.parentHabits();
        child.childHabits();
        Parent child2 = new AbstractClass().new Child2();
        child2.parentHabits();
        child2.childHabits();
    }


}

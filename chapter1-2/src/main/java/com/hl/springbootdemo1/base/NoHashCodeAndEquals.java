package com.hl.springbootdemo1.base;

import java.util.HashMap;

/**
 * 用对象做key
 */
public class NoHashCodeAndEquals {
    public static void main(String[] args) {
        Object o = new Object();
        HashMap<Demo, String> hashMap = new HashMap<>();
        Demo a = new Demo("A");
        Demo b = new Demo("A");
        hashMap.put(a, "Hello World");
        String s = hashMap.get(b);
        System.out.println(s);

    }
}

class Demo {
    String key;

    Demo(String key) {
        this.key = key;
    }
}

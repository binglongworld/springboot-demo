package com.hl.springbootdemo1.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量池分区位置测试
 */
public class StringConstantPoolTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        while (true) {
            list.add(String.valueOf(System.currentTimeMillis()).intern());
        }
    }
}

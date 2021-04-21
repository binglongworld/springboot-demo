package com.hl.chapter14.web;

import org.springframework.stereotype.Controller;

/**
 * 测试控制器类
 */
@Controller
public class DemoController {

    public String handleRequest() {
        System.out.println("------------DemoController handleRequest执行-----------");
        return "";
    }
}

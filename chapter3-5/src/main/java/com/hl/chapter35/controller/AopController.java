package com.hl.chapter35.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aop")
public class AopController {

    @RequestMapping(value = "/test")
    public String testAop(String key) {
        return "testAop: key = " + key;
    }

    @RequestMapping(value = "/testAfterThrowing")
    public String testAfterThrowing(String key) {
        throw new NullPointerException(key);
    }

    @RequestMapping(value = "/testAround")
    public String testAround(String key) {
        return "环绕通知: key = " + key;
    }
}

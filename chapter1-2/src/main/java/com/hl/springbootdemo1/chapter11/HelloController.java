package com.hl.springbootdemo1.chapter11;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {
    @RequestMapping(value = "index")
    public String index() {
        return "Hello World";
    }
}

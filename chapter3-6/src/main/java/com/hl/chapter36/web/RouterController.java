package com.hl.chapter36.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {
    @RequestMapping({"/", "/index"})
    public String index() {
//        String pwd = new BCryptPasswordEncoder().encode("12345");
//        System.out.println("BCrypt: " + pwd);
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id) {
        return "level1/" + id;
    }

    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id) {
        return "level2/" + id;
    }

    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id) {
        return "level3/" + id;
    }

}

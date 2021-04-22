package com.hl.chapter37.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name", null);
        modelAndView.addObject("sex", "女");
        List<Map> users = new ArrayList<Map>();
        for (int i = 0; i < 10; i++) {
            Map map = new HashMap();
            map.put("name", "A-" + i);
            map.put("sex", i % 2 == 0 ? "男" : "女");
            map.put("age", new Random().nextInt(100));
            users.add(map);

        }
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/toLogin")
    public String toLogin() {
        return "login";
    }
}

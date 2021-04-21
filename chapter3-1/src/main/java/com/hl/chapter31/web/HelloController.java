package com.hl.chapter31.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HelloController {

    @GetMapping(value = "/")
    public String index(ModelMap modelMap) {
        log.info("调用/ GET接口");
        modelMap.addAttribute("host", "www.google.com.cn");
        return "index";
    }
}

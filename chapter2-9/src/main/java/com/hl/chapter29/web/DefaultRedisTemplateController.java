package com.hl.chapter29.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultRedisTemplateController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index() {
        redisTemplate.opsForValue().set("默认模板", "是否乱码");
        System.out.println(redisTemplate.opsForValue().get("默认模板"));

        return null;

    }
}

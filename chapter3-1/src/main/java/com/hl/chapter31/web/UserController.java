package com.hl.chapter31.web;

import com.hl.chapter31.entity.User;
import com.hl.chapter31.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Api(tags = "用户管理")
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CacheManager cacheManager;

    @ApiOperation(value = "新增用户")
    @PostMapping("/user")
    public int create(@RequestBody User user) {
        return userMapper.insert(user.getName(), user.getAge());
    }

    @ApiOperation(value = "根据姓名获取用户", tags = "用户管理")
    @GetMapping("/user/{name}")
    public User findByName(@PathVariable String name) {
        return userMapper.findByName(name);
    }

    @ApiOperation(value = "删除所有用户")
    @DeleteMapping("/user")
    public int deleteAllUsers(@PathVariable String name) {
        return userMapper.deleteUser();
    }

    @GetMapping("/create")
    public void create() {
        userMapper.insert("AAA", 10);
    }

    @GetMapping("/find")
    public User find() {
        Collection<String> names = cacheManager.getCacheNames();
        for (String name : names) {
            log.info("缓存的key: " + name);
        }

        User u1 = userMapper.findByName("AAA");
        System.out.println("查询AAA用户：" + u1.getAge());
        return u1;
    }

}

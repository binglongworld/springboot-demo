package com.hl.chapter24.web;

import com.hl.chapter24.entity.User;
import com.hl.chapter24.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "用户管理")
@RestController
public class Chapter24UserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "新增用户")
    @PostMapping("/user")
    public String create(@Valid @RequestBody User user) {
        userMapper.insert(user.getName(), user.getAge());
        return "SUCCESS";
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

}

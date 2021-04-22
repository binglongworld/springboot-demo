package com.hl.springbootdemo1.chapter21.web;

import com.hl.springbootdemo1.chapter21.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Api(tags = "用户信息接口")
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    // 线程安全的map
    Map<Long, User> users = new ConcurrentHashMap();
    // 创建线程安全的Map，模拟users信息的存储
//    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    //    @GetMapping(value = "/", produces = "application/json;charset=UTF-8")
    @ApiOperation("获取用户列表")
    @GetMapping(value = "/", produces = "application/json;charset=UTF-8")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>(users.values());
//        System.out.println(userList.toString());
        return userList;
    }

    @ApiOperation(value = "添加新用户", notes = "根据user创建用户")
    @PostMapping(value = "/")
    public Object postUsers(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldErrors();
        } else {
            users.put(user.getId(), user);
            return "SUCCESS";
        }
    }

    @ApiOperation("根据id查询用户的接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "", required = true)
    @GetMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
    public User getUser(@PathVariable Long id) {
        User user = users.get(id);
//        System.out.println(user.toString());
        return user;
    }

    @ApiOperation("根据id修改用户信息的接口")
    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable("id") Long id, @Valid @RequestBody User user) {
//        System.out.println(user.toString());
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        System.out.println(u.toString());
        return "SUCCESS";
    }

    @ApiOperation("根据id删除用户的接口")
    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        users.remove(id);
        return "SUCCESS";
    }
}

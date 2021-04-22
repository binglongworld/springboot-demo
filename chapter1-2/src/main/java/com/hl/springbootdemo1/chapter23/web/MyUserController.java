package com.hl.springbootdemo1.chapter23.web;

import com.hl.springbootdemo1.chapter23.entity.User;
import com.hl.springbootdemo1.chapter23.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chapter23")
public class MyUserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public int create(@RequestBody User user) {
        return userService.create(user.getName(), user.getAge());
    }

    @GetMapping("/user/{name}")
    public List<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @DeleteMapping("/user/{name}")
    public int deleteByName(@PathVariable String name) {
        return userService.deleteByName(name);
    }

    @GetMapping("/user/count")
    public int getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/user/all")
    public int deleteAllUsers() {
        return userService.deleteAllUsers();
    }
}

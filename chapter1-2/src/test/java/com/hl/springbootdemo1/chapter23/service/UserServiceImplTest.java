package com.hl.springbootdemo1.chapter23.service;

import com.hl.springbootdemo1.chapter23.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        // 准备，清空user表
        userService.deleteAllUsers();
    }

    @Test
    public void test() throws Exception {
        // 插入6个用户
        userService.create("张三", 10);
        userService.create("李四", 12);
        userService.create("王五", 14);
        userService.create("赵六", 16);
        userService.create("孙七", 18);
        userService.create("周八", 20);

        // 查询姓名为王五的用户，看年龄是否相符
        List<User> userList = userService.getByName("王五");
        Assert.assertEquals(14, userList.get(0).getAge().intValue());

        // 查询数据库，应该有6个用户
        Assert.assertEquals(6, userService.getAllUsers());

        // 删除两个用户
        userService.deleteByName("李四");
        userService.deleteByName("孙七");

        // 查询数据库，应该还有4个用户
        Assert.assertEquals(4, userService.getAllUsers());
    }

}
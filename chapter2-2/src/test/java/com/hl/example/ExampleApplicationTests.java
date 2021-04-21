package com.hl.example;

import com.hl.example.entity.User;
import com.hl.example.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExampleApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void test() throws Exception {
        // 先清空表
        userMapper.deleteUser();
        // 使用参数
        userMapper.insert("宋江", 45);
        User user = userMapper.findByName("宋江");
        Assert.assertEquals(45, user.getAge().intValue());
        log.info(user.toString());

        // 使用Map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "卢俊义");
        map.put("age", 40);
        userMapper.insertByMap(map);
        User user2 = userMapper.findByName("卢俊义");
        Assert.assertEquals(40, user2.getAge().intValue());
        log.info(user2.toString());

        // 使用对象
        User user3 = new User();
        user3.setName("吴用");
        user3.setAge(38);
        userMapper.insertByUser(user3);
        User user4 = userMapper.findByName("吴用");
        Assert.assertEquals(38, user4.getAge().intValue());
        log.info(user4.toString());

    }

}

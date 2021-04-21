package com.hl.example;

import com.hl.example.entity.User;
import com.hl.example.mapper.primary.UserMapperPrimary;
import com.hl.example.mapper.secondary.UserMapperSecondary;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ExampleApplicationTests {
    @Autowired
    private UserMapperPrimary userMapperPrimary;
    @Autowired
    private UserMapperSecondary userMapperSecondary;

    @Before
    public void setUp() {
        // 清空测试表，保证每次结果一样
        userMapperPrimary.deleteUser();
        userMapperSecondary.deleteUser();
    }

    @Test
    public void test() throws Exception {
        // 往Primary数据源插入一条数据
        userMapperPrimary.insert("AAA", 20);

        // 从Primary数据源查询刚才插入的数据，配置正确就可以查询到
        User user = userMapperPrimary.findByName("AAA");
        Assert.assertEquals(20, user.getAge().intValue());

        // 从Secondary数据源查询刚才插入的数据，配置正确应该是查询不到的
        User userSecondary = userMapperSecondary.findByName("AAA");
        Assert.assertNull(userSecondary);

        // 往Secondary数据源插入一条数据
        userMapperSecondary.insert("BBB", 20);

        // 从Primary数据源查询刚才插入的数据，配置正确应该是查询不到的
        user = userMapperPrimary.findByName("BBB");
        Assert.assertNull(user);

        // 从Secondary数据源查询刚才插入的数据，配置正确就可以查询到
        userSecondary = userMapperSecondary.findByName("BBB");
        Assert.assertEquals(20, userSecondary.getAge().intValue());

    }

}

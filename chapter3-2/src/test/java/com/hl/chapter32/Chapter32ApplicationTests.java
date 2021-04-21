package com.hl.chapter32;

import com.hl.chapter32.entity.User;
import com.hl.chapter32.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class Chapter32ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CacheManager cacheManager;

    @Test
    @Rollback
    public void test() throws Exception {
        log.info("cacheManager type: " + cacheManager.getClass());
        // 先清空表
        userMapper.deleteUser();

        // 创建一条记录
        userMapper.insert("AAA", 10);

        // 第一次查询
        User user = userMapper.findByName("AAA");
        log.info("第一次查询：" + user.getAge());
        Iterator<String> iterators = cacheManager.getCacheNames().iterator();
        while (iterators.hasNext()) {
            log.info("缓存名称：" + iterators.next());
        }
        // 第二次查询
        User user2 = userMapper.findByName("AAA");
        log.info("第二次查询：" + user2.getAge());

    }

}

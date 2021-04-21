package com.hl.chapter24;

import com.hl.chapter24.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class Chapter24ApplicationTests {

    @Autowired
    WebApplicationContext context;
    @Autowired
    private UserMapper userMapper;

    private MockMvc mvc;

    @Before
    public void setUp() {
//        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
        userMapper.deleteUser();
    }

    @Test
    @Transactional
    @Rollback
    public void test() throws Exception {

        RequestBuilder request;
        // 插入10条记录
        for (int i = 0; i < 10; i++) {
            request = post("/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"name\":\"AA\",\"age\":" + (i + 1) * 10 + "}");
            mvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(content().string(equalTo("SUCCESS")));
        }


    }

}

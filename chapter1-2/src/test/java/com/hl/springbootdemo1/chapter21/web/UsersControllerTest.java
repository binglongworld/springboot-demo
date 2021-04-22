package com.hl.springbootdemo1.chapter21.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsersControllerTest {
    @Autowired
    WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new UsersController()).build();
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testUserController() throws Exception {
        // 测试UserController
        RequestBuilder request;

        // 1、getUsers()
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")))
                .andDo(print());

        // 2、post一个user
        request = post("/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"莫言\",\"age\":50}");
        mvc.perform(request)
                .andExpect(content().string(equalTo("SUCCESS")));

        // 3、get获取user列表，应该有刚才插入的用户
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"莫言\",\"age\":50}]")))
                .andDo(print());

        // 4、put修改id为1的user
        request = put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"测试专家\",\"age\":20}");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("SUCCESS")));

        // 5、get一个id为1的user
        request = get("/users/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试专家\",\"age\":20}")));

        // 6、delete删除id为1的user
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("SUCCESS")));

        // 7、get一下user列表
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

    }


}
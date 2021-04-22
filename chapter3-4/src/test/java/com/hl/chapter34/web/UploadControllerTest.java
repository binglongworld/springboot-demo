package com.hl.chapter34.web;

import com.hl.chapter34.Chapter34Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Chapter34Application.class)
public class UploadControllerTest {
    @Autowired
    WebApplicationContext context;
    protected MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void create() throws Exception {
        MockMultipartFile file = new MockMultipartFile("files",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello World!".getBytes()
        );

        final MvcResult result = mvc.perform(
                MockMvcRequestBuilders
                        .multipart("/upload")
                        .file(file))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
package com.nooyi.spring.cloud.study.gateway.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 
 *
 * @author Cheney
 * @date 2023-02-20 22:32
 * @
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class helloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void hello() throws Exception {
        String responseString = mvc.perform(MockMvcRequestBuilders
                                                    .get("/hello/str")
                                                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("response in junit test :\n" + responseString);
    }
}
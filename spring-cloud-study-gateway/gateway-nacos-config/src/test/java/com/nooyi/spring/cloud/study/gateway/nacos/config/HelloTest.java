package com.nooyi.spring.cloud.study.gateway.nacos.config;

import com.nooyi.common.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Cheney
 * @date 2023-02-20 22:54
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
public class HelloTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testHelloPredicates() {
        webClient.get()
                .uri("/hello/str")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                // 验证状态
                .expectStatus().isOk()
                // 验证结果，注意结果是字符串格式
                .expectBody(String.class)
                .consumeWith(result  -> assertTrue(result.getResponseBody().contains(Constants.HELLO_PREFIX)));
    }

    @Test
    void testLoadBalance() {
        webClient.get()
                .uri("/lb/str")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                // 验证状态
                .expectStatus().isOk()
                // 验证结果，注意结果是字符串格式
                .expectBody(String.class)
                .consumeWith(result -> assertTrue(result.getResponseBody().contains(Constants.LB_PREFIX)));
    }
}

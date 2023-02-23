package com.nooyi.spring.cloud.study.gateway.circuit.breaker;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * 为了验证Spring Cloud Gateway的断路器功能，咱们可以用Junit单元测试来精确控制请求参数和请求次数，测试类如下，
 * 可见测试类会连续发一百次请求，在前五十次中，请求参数始终在0和1之间切换，参数等于1的时候，接口会有500毫秒延时，
 * 超过了Spring Cloud Gateway的200毫秒超时限制，这时候就会返回失败，等失败多了，就会触发断路器的断开
 * 
 * @author Cheney
 * @date 2023-02-23 22:19
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
public class CircuitBreakerTest {
    // 测试的总次数
    private static int i=0;

    @Autowired
    private WebTestClient webClient;

    @Test
    @RepeatedTest(100)
    void testHelloPredicates() throws InterruptedException {
        // 低于50次时，gen在0和1之间切换，也就是一次正常一次超时，
        // 超过50次时，gen固定为0，此时每个请求都不会超时
        int gen = (i<50) ? (i % 2) : 0;

        // 次数加一
        i++;

        final String tag = "[" + i + "]";

        // 发起web请求
        webClient.get()
                .uri("/hello/account/" + gen)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody(String.class).consumeWith(result  -> System.out.println(tag + result.getRawStatusCode() + " - " + result.getResponseBody()));

        Thread.sleep(1000);
    }
}

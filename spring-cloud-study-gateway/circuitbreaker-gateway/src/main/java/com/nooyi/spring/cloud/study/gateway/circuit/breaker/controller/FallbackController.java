package com.nooyi.spring.cloud.study.gateway.circuit.breaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cheney
 * @date 2023-02-23 22:53
 */
@RestController
public class FallbackController {
    private String dateStr(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * 返回字符串类型
     * @return
     */
    @GetMapping("/myfallback")
    public String helloStr() {
        return "myfallback, " + dateStr();
    }
}

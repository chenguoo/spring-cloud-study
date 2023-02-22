package com.nooyi.spring.cloud.study.gateway.hello.controller;

import com.nooyi.common.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Cheney
 * @date 2023-02-20 22:31
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private String dateStr(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }

    /**
     * 返回字符串类型
     * @return
     */
    @GetMapping("/str")
    public String helloStr() {
        return Constants.HELLO_PREFIX + ", now: " + dateStr();
    }
}

package com.nooyi.spring.cloud.study.gateway.hello.controller;

import com.nooyi.common.Constants;
import org.springframework.web.bind.annotation.*;

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
        return Constants.HELLO_PREFIX + ", " + dateStr();
    }
    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public String account(@PathVariable("id") int id) throws InterruptedException {
        if(1==id) {
            Thread.sleep(500);
        }

        return Constants.ACCOUNT_PREFIX +", "+ dateStr();
    }

}

package com.nooyi.spring.cloud.gateway.dynamic.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Cheney
 * @date 2023-02-21 22:30
 * @see https://xinchen.blog.csdn.net/article/details/119705402
 */
@SpringBootApplication
public class NacosDynamicConfigApplication
{
    public static void main( String[] args ) {

        SpringApplication.run(NacosDynamicConfigApplication.class, args);
    }
}

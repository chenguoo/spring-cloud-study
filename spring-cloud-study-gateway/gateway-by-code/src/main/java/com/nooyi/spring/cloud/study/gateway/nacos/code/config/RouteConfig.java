package com.nooyi.spring.cloud.study.gateway.nacos.code.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cheney
 * @date 2023-02-21 22:34
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customizeRoute(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(
                        // 第一个参数是路由的唯一身份
                        "path_route_lb",
                        // 第二个参数是个lambda实现，
                        // 设置了配套条件是按照请求路径匹配，以及转发地址，
                        // 注意lb://表示这是个服务名，要从
                        r -> r.path("/lb/**").uri("lb://provider-hello")
                )
                .build();
    }
}

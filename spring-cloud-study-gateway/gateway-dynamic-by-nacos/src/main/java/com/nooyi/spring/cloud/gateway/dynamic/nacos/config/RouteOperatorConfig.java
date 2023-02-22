package com.nooyi.spring.cloud.gateway.dynamic.nacos.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nooyi.spring.cloud.gateway.dynamic.nacos.operator.RouteOperator;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cheney
 * @date 2023-02-22 21:05
 */
@Configuration
public class RouteOperatorConfig {
    @Bean
    public RouteOperator routeOperator(ObjectMapper objectMapper,
                                       RouteDefinitionWriter routeDefinitionWriter,
                                       ApplicationEventPublisher applicationEventPublisher) {

        return new RouteOperator(objectMapper, routeDefinitionWriter, applicationEventPublisher);
    }
}

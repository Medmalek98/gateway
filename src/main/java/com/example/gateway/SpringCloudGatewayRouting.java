package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configuRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("gestionCandidat", r -> r.path("/apispring/**").uri("http://springservice:8081"))
                .route("nodeMicroservice", r -> r.path("/apinode/**").uri("http://nodejsservice:3000"))
                .route("eureka", r -> r.path("/**").uri("http://eurekaserver:8761"))
                .build();
    }
}

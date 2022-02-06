package com.rhombusthere.codemotioncloudpath.proxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableZuulProxy
public class CodemotionCloudPathProxyService {

    public static void main(String[] args) {
        SpringApplication.run(CodemotionCloudPathProxyService.class, args);
    }

    //TODO
    // Circuit Breaker with Hystrix?
}

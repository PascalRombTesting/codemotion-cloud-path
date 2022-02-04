package com.rhombusthere.codemotioncloudpath.proxyservice.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public PreAuthenticatedFilter preFilter() {
        return new PreAuthenticatedFilter();
    }
    @Bean
    public PostAuthenticationFilter postFilter() {
        return new PostAuthenticationFilter();
    }
}

package com.rhombusthere.codemotioncloudpath.proxyservice.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "authentication")
@Setter @Getter
public class AuthenticationProperties {
    private String secret;
    private int expirationTimeInMinutes = 5;
}

package com.rhombusthere.codemotioncloudpath.loginservice.security;


import com.rhombusthere.codemotioncloudpath.loginservice.model.UserBasic;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@ConfigurationProperties(prefix = "security")
@Data
public class BasicAuthenticationProperties {
    private Set<UserBasic> allowedUsers;
}

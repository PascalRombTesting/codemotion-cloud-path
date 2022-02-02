package com.rhombushthere.codemotioncloudpath.loginservice.security;


import com.rhombushthere.codemotioncloudpath.loginservice.model.UserBasic;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@ConfigurationProperties(prefix = "security")
@Data
public class BasicAuthenticationProperties {
    private Set<UserBasic> allowedUsers;
}

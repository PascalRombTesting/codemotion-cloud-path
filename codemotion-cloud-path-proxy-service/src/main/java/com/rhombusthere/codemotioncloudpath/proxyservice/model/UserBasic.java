package com.rhombusthere.codemotioncloudpath.proxyservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBasic {
    private String username;
    private String password;
}

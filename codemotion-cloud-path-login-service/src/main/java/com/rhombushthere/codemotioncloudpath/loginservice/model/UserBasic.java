package com.rhombushthere.codemotioncloudpath.loginservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBasic {
    private String username;
    private String password;
}

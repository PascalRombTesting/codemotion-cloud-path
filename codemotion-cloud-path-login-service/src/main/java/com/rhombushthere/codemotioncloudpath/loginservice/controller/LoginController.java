package com.rhombushthere.codemotioncloudpath.loginservice.controller;


import com.rhombushthere.codemotioncloudpath.loginservice.model.UserBasic;
import com.rhombushthere.codemotioncloudpath.loginservice.security.BasicAuthenticationProperties;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class LoginController {

    private final BasicAuthenticationProperties basicAuthenticationProperties;

    public LoginController(BasicAuthenticationProperties basicAuthenticationProperties) {
        this.basicAuthenticationProperties = basicAuthenticationProperties;
    }

    @ApiOperation(value = "Login", notes = "Login with given credentials.")
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserBasic userBasic) {
        if(basicAuthenticationProperties.getAllowedUsers().contains(userBasic)){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}

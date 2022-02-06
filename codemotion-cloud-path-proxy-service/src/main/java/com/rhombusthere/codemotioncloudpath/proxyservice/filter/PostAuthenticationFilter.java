package com.rhombusthere.codemotioncloudpath.proxyservice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.rhombusthere.codemotioncloudpath.proxyservice.model.UserBasic;
import com.rhombusthere.codemotioncloudpath.proxyservice.response.ResponseUtils;
import com.rhombusthere.codemotioncloudpath.proxyservice.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class PostAuthenticationFilter extends ZuulFilter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("Request [Method: %s, URL: %s]",request.getMethod(), request.getRequestURL().toString()));

        if(ctx.getResponse().getStatus() != HttpStatus.OK.value()){
            return null;
        }

        //handle only 200, creating jwt
        try {
            UserBasic userBasic = objectMapper.readValue(ctx.getRequest().getInputStream(), UserBasic.class);
            String jwtToken = AuthenticationService.getJwtToken(userBasic);
            ResponseUtils.loginSuccessResponse(ctx, jwtToken, userBasic.getUsername());
        } catch (IOException e) {
            ResponseUtils.internalServerError(ctx, e);
        }
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getRequest().getRequestURI().contains("login-service");
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}

package com.rhombusthere.codemotioncloudpath.proxyservice.response;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResponseUtils {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_BEARER = "Bearer ";

    public static void internalServerError(RequestContext ctx,Exception ex) {
        log.error("Internal Server error", ex);
        ctx.setSendZuulResponse(false);
        ctx.setResponseBody(ex.toString());
        ctx.setResponseStatusCode(500);
    }

    public static void loginSuccessResponse(RequestContext ctx, String token, String username) {
        log.info(String.format("Login successful for %s",username));

        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(200);
        ctx.setResponseBody(AUTHORIZATION_BEARER + token);
    }


    public static void unauthorizedResponse(RequestContext ctx, String username) {
        log.info(String.format("User %s not authorized", username));
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(401);
    }
}

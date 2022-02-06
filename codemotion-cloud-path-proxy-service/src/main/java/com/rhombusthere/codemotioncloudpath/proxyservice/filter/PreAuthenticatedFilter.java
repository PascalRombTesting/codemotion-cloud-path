package com.rhombusthere.codemotioncloudpath.proxyservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.rhombusthere.codemotioncloudpath.proxyservice.response.ResponseUtils;
import com.rhombusthere.codemotioncloudpath.proxyservice.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import static com.rhombusthere.codemotioncloudpath.proxyservice.response.ResponseUtils.AUTHORIZATION_BEARER;
import static com.rhombusthere.codemotioncloudpath.proxyservice.response.ResponseUtils.AUTHORIZATION_HEADER;


@Slf4j
public class PreAuthenticatedFilter extends ZuulFilter {

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("Request [Method: %s, URL: %s]",request.getMethod(), request.getRequestURL().toString()));

        if(request.getHeader(AUTHORIZATION_HEADER)==null ||
                !AuthenticationService.isValid(request.getHeader(AUTHORIZATION_HEADER).replace(AUTHORIZATION_BEARER, ""))) {
            ResponseUtils.unauthorizedResponse(ctx, "");
        }
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return !RequestContext.getCurrentContext().getRequest().getRequestURI().contains("login-service");
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}

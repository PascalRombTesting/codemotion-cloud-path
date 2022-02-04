package com.rhombusthere.codemotioncloudpath.proxyservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


public class PreAuthenticatedFilter extends ZuulFilter {

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //ctx.addZuulRequestHeader("Test", "TestSample");

        //TODO if request is not for login service
        // then validate token
        // if not good return unauthorize, null otherwise



        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
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

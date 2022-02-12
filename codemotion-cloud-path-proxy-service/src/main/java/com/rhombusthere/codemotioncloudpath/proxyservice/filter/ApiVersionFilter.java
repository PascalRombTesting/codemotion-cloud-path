package com.rhombusthere.codemotioncloudpath.proxyservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ApiVersionFilter extends ZuulFilter {
    @Autowired
    ZuulProperties zuulProperties;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //TODO get path
        // get service from path using zuulProperties
        // get api version from map using service-id
        //change route path add version
        RequestContext ctx = RequestContext.getCurrentContext();

        String[] split = ctx.getRequest().getRequestURI().split("/");
        ArrayList<String> strings = new ArrayList<>(List.of(split));
        strings.remove(0);
        int index = -1;
        for (int i = 0; i < strings.size(); i++) {
            if(zuulProperties.getRoutes().containsKey(strings.get(i))) {
                index = i;
            }
        }

        if(index == -1) {
            throw new IllegalArgumentException();
        }

        String routeId = zuulProperties.getRoutes().get(strings.get(index)).getId();
        strings.add(index + 1, "api/v1");

        StringBuilder newUrl = new StringBuilder();
        for (String string : strings) {
            newUrl.append("/").append(string);
        }

        //String modifiedRequestPath = new
        final RequestContext context = RequestContext.getCurrentContext();

        // get current ZuulRoute
        //final String proxy = (String) context.get(FilterConstants.PROXY_KEY);
        final ZuulProperties.ZuulRoute zuulRoute = this.zuulProperties.getRoutes().get(strings.get(index));

        // patch URL by prefixing it with zuulRoute.url
        final Object originalRequestPath = context.get(FilterConstants.REQUEST_URI_KEY);
        context.put(FilterConstants.REQUEST_URI_KEY, "/login-service/api/v1/login");

        // patch serviceId because :
        // - has been set to route.location in PreDecorationFilter
        // - route.location has been set to zuulRoute.location in SimpleRouteLocator
        // - zuulRoute.location return zuulRoute.url if set
        context.set(FilterConstants.SERVICE_ID_KEY, zuulRoute.getServiceId());

        return null;

    }
}

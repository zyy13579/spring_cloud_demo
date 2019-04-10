package com.ewing.getway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PasswordFilter extends ZuulFilter {
    private final Logger LOGGER = LoggerFactory.getLogger(PasswordFilter.class);
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getBoolean("isSuccess");
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("--->>> PasswordFilter {},{}",request.getMethod(),request.getRequestURL().toString());
        String password = request.getParameter("password");
        if(null != password && password.equals("123456")){
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess",true);
            return null;
        }
        else{
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("The password cannot be empty");
            ctx.set("isSuccess",false);
            return null;
        }
    }
}

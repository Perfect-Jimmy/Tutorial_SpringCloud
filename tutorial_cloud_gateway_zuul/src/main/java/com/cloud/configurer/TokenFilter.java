package com.cloud.configurer;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jimmy. 2018/6/8  22:59
 * Token过滤器
 * 请求中含有Token便让请求继续往下走,如果请求不带Token就直接返回并给出提示
 */
@Component
public class TokenFilter extends ZuulFilter {

    /**
     * 过滤器的类型,它决定过滤器在请求的哪个生命周期中执行
     * 这里定义为pre,代表会在请求被路由之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序,通过数字指定
     * 数字越大,优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行,这里我们直接返回了true,因此该过滤器对所有请求都会生效
     * 实际运用中我们可以利用该函数来指定过滤器的有效范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;//是否执行该过滤器,true代表需要过滤
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("---");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("---"+request);
        String token = request.getParameter("token");
        if (token == null || token.isEmpty()) {
            ctx.setSendZuulResponse(false);// Zuul过滤该请求,不对其进行路由
            ctx.setResponseStatusCode(401);// 返回的错误码
            ctx.setResponseBody("token is empty");
        }
        return null;
    }
}

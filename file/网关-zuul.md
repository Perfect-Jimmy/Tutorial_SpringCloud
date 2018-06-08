### 网关 zuul  https://windmt.com/2018/04/23/spring-cloud-11-zuul-filter/
#### 路由 Router
1. 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
    <version>${zuul.version}</version>
</dependency>
```

2. 添加注解: @EnableZuulProxy
```
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerStart {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerStart.class,args);
    }
}
```

3. 测试网关
Spring Cloud Zuul 在整合了 Eureka 之后,具备默认的服务路由功能,即:当我们这里构建的zuul-server应用启动并注册到Eureka之后,
服务网关会发现上面我们启动的服务book-server,这时候Zuul就会创建默认路由规则,路由规则包含两部分,一部分是外部请求的匹配规则,另一部分是路由的服务ID,
如:转发到book-server服务的请求规则为：/book-server/**
```
访问:http://localhost:7777/book-server/book 该请求将最终被路由到book-server的/book接口上
```

#### 过滤器 Filter
Filter的生命周期有4个,分别是PRE、ROUTING、POST和ERROR.  
Zuul大部分功能都是通过过滤器来实现的,这些过滤器类型对应于请求的典型生命周期:  
1. PRE:在请求被路由之前调用.我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等
2. ROUTING:将请求路由到微服务.这种过滤器用于构建发送给微服务的请求,并使用Apache HttpClient或Netfilx Ribbon请求微服务
3. POST:在路由到微服务以后执行.这种过滤器可用来为响应添加标准的HTTP Header,收集统计信息和指标、将响应从微服务发送给客户端等
4. ERROR:在其他阶段发生错误时执行该过滤器.  
除了默认的过滤器类型,Zuul还允许我们创建自定义的过滤器类型.例如,我们可以定制一种STATIC类型的过滤器,直接在Zuul中生成响应,而不将请求转发到后端的微服务


#### 自定义Filter
1. 自定义一个Filter,继承ZuulFilter抽象类
```
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
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String token = request.getParameter("token");
        if (token == null || token.isEmpty()) {
            ctx.setSendZuulResponse(false);// Zuul过滤该请求,不对其进行路由
            ctx.setResponseStatusCode(401);// 返回的错误码
            ctx.setResponseBody("token is empty");
        }
        return null;
    }
}
```

2. 验证
http://localhost:7777/book-server/book?token=hello 
http://localhost:7777/book-server/book

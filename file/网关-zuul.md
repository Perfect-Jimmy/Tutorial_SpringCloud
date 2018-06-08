### 网关 zuul 
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


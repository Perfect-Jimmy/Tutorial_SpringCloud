### hystrix dashboard
1. 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    <version>${hystrix.version}</version>
</dependency>
```

2. 添加注解:@EnableHystrixDashboard
```
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class FeignStart {
    public static void main(String[] args) {
        SpringApplication.run(FeignStart.class,args);
    }
}
```

3. 访问:http://localhost:4444/hystrix

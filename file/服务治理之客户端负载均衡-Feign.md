### 服务治理之客户端负载均衡 Feign
1. 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
    <version>2.0.0.M1</version>
</dependency>
```
2. 添加注解:@EnableFeignClients
```
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BookServerStart {
    public static void main(String[] args) {
        SpringApplication.run(BookServerStart.class,args);
    }
}
```
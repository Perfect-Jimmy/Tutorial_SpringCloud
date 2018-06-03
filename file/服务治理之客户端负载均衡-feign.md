### 服务治理之客户端负载均衡 Feign
1. 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
    <version>2.0.0.M1</version>
</dependency>
```

2. 添加注解 
```
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerStart {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerStart.class,args);
    }
}
```

3. 声明feign接口
```
@FeignClient(name="book-server")
@Service
public interface BookClient {

    @GetMapping("/book")
    String book();
}
```

4. 声明controller
```
@RestController
public class FeignController {

    @Autowired
    BookClient bookClient;

    @GetMapping("/feignTest")
    public String feignTest() {
        return bookClient.book();
    }
}
```
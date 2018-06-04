### 服务降级 hystrix
在微服务架构中,我们将系统拆分成了一个个的服务单元,各单元应用间通过服务注册与订阅的方式互相依赖.由于每个单元都在不同的进程中运行,
依赖通过远程调用的方式执行,这样就有可能因为网络原因或是依赖服务自身问题出现调用故障或延迟,而这些问题会直接导致调用方的对外服务也出现延迟,
若此时调用方的请求不断增加,最后就会出现因等待出现故障的依赖方响应而形成任务积压,线程资源无法释放,最终导致自身服务的瘫痪,进一步甚至出现故障的蔓延最终导致整个系统的瘫痪.
如果这样的架构存在如此严重的隐患,那么相较传统架构就更加的不稳定.为了解决这样的问题,因此产生了断路器等一系列的服务保护机制.

1. 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    <version>${hystrix.version}</version>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
    <version>${hystrix.version}</version>
</dependency>
```

2. 添加注解:@EnableHystrix
```
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ConsumerStart {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerStart.class,args);
    }
}
```
3. 开启容错
```
feign:
  hystrix:
    enabled: true # 开启容错
```

4. 声明容错处理类(方法)
```
@Component
public class BookClientFallbackService implements BookClient {
    @Override
    public String book() {
        return "book fall back";
    }
}
```

5. feign接口中指定fallback参数
```
@FeignClient(name="book-server",fallback = BookClientFallbackService.class)
@Service
public interface BookClient {

    @GetMapping("/book")
    String book();
}
```
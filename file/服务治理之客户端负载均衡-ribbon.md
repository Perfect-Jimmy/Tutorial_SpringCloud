### 负载均衡 ribbon
ribbon客户端负载均衡,通过在客户端中配置ribbonServerList来设置服务端列表去轮询访问以达到均衡负载的作用.
1. 初始化restTemplate
```
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerStart {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerStart.class,args);
    }

    /**
     * 初始化restTemplate
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```
2. 声明controller
```
@GetMapping("/ribbonTest")
public String ribbonTest() {
    //相比ribbonSimpleTest示例,这里请求的host位置并没有使用一个具体的IP地址和端口的形式
    //因为Spring Cloud Ribbon有一个拦截器,它能够在这里进行实际调用的时候,自动的去选取服务实例,
    //并将实际要请求的IP地址和端口替换这里的服务名,从而完成服务接口的调用
    return restTemplate.getForObject("http://book-server/book", String.class);
}
```
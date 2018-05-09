### 服务注册与发现
#### 注册中心
1. 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    <version>2.0.0.RC1</version>
</dependency>
```

2. 添加注解:@EnableEurekaServer
```
@SpringBootApplication
@EnableEurekaServer
public class CloudServerStart {
    public static void main(String[] args) {
        SpringApplication.run(CloudServerStart.class,args);
    }
}
```

3. 配置文件
```
# 表示是否从Eureka Server获取注册信息,默认为true.因为这是一个单点的Eureka Server不需要同步其他的Eureka Server节点的数据,故设为false
eureka.client.fetch-registry=false
# 表示是否将自己注册到Eureka Server,默认为true
eureka.client.register-with-eureka=false 
# 设置与Eureka Server交互的地址,查询服务和注册服务都需要依赖这个地址
eureka.client.serviceUrl.defaultZone=http://localhost:8090/eureka/
```

4. 启动访问:http://localhost:port


#### 服务注册
1. 引入依赖
```
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
   <version>2.0.0.RC1</version>
</dependency>
```

2. 添加注解:@EnableEurekaServer
```
@SpringBootApplication
@EnableEurekaClient
public class CloudClientStart_1 {
    public static void main(String[] args) {
        SpringApplication.run(CloudClientStart_1.class,args);
    }
}
```

3. 配置文件
```
# 服务名称 微服务的名称后续在调用的时候只需要使用该名称就可以进行服务的访问
spring.application.name=compute-service1
# 在注册中心中进行注册 对应服务注册中心的配置内容,指定服务注册中心的位置
eureka.client.serviceUrl.defaultZone=http://localhost:1111/eureka/
# 启动服务发现的功能,开启了才能调用其它服务
spring.cloud.config.discovery.enabled=true  
# 发现的服务的名字--对应注测中心的服务名字
spring.cloud.config.discovery.serviceId=compute-client1
```
package com.cloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jimmy. 2018/6/3  12:11
 */
@RestController
public class RibbonController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ribbonSimpleTest")
    public String ribbonSimpleTest() {
        //choose 负载均衡的选出一个eureka-client的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-server");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/book";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/ribbonTest")
    public String ribbonTest() {
        //相比ribbonSimpleTest示例,这里请求的host位置并没有使用一个具体的IP地址和端口的形式
        //因为Spring Cloud Ribbon有一个拦截器,它能够在这里进行实际调用的时候,自动的去选取服务实例,
        //并将实际要请求的IP地址和端口替换这里的服务名,从而完成服务接口的调用
        return restTemplate.getForObject("http://book-server/book", String.class);
    }
}

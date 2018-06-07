package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Jimmy. 2018/5/11  18:29
 * https://github.com/SoftwareKing/sc-gateway/tree/master/ch1
 * https://www.jianshu.com/p/899f562fdbb9
 * http://www.spring4all.com/article/961
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerStart {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerStart.class,args);
    }

}

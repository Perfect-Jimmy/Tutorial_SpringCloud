package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Jimmy. 2018/5/11  18:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerStart {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerStart.class,args);
    }
}

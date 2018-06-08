package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Jimmy. 2018/6/8  20:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulServerStart {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerStart.class,args);
    }
}

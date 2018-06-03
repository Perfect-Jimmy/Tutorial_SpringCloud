package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Jimmy. 2018/5/10  17:12
 * 服务提供者 book
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BookServerStart {
    public static void main(String[] args) {
        SpringApplication.run(BookServerStart.class,args);
    }
}

package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Jimmy. 2018/5/4  16:14
 * 注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudServerStart {

    public static void main(String[] args) {
        SpringApplication.run(CloudServerStart.class,args);
    }
}

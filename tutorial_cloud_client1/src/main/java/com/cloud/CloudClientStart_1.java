package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Jimmy. 2018/5/9  15:44
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudClientStart_1 {

    public static void main(String[] args) {
        SpringApplication.run(CloudClientStart_1.class,args);
    }
}

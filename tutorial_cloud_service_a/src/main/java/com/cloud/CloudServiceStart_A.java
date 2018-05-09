package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Jimmy. 2018/5/9  17:05
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudServiceStart_A {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceStart_A.class,args);
    }
}

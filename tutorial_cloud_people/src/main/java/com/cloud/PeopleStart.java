package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Jimmy. 2018/5/10  17:16
 * https://www.bilibili.com/video/av24231421/
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker 开启容错
public class PeopleStart {

    public static void main(String[] args) {
        SpringApplication.run(PeopleStart.class,args);
    }
}

package com.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jimmy. 2018/5/10  17:29
 */
@RestController
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("book")
    public String bookTest() throws InterruptedException {
        //Thread.sleep(1000*3L);
        String service = discoveryClient.getServices().toString();
        logger.info("service:{}",service);//[book-server, people_service]  即yml中配置的application name.
        return service;
    }
}

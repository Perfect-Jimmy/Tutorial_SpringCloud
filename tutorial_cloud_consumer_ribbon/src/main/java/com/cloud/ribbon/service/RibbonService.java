package com.cloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jimmy. 2018/6/4  11:46
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

  /*  @HystrixCommand(fallbackMethod = "fallback")
    public String ribbonHystrix() {
        return restTemplate.getForObject("http://book-server/book", String.class);
    }

    public String fallback() {
        return "fallback";
    }*/

}

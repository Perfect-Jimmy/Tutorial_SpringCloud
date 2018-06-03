package com.cloud.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jimmy. 2018/6/3  12:45
 */
@RestController
public class FeignController {

    @Autowired
    BookClient bookClient;

    @GetMapping("/feignTest")
    public String feignTest() {
        System.out.println("---");
        return bookClient.book();
    }
}

package com.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Jimmy. 2018/6/3  12:48
 */
@FeignClient(name="book-server")
public interface BookClient {

    @GetMapping("/book")
    String book();
}

package com.cloud.controller;

import com.cloud.hystrix.fallback.BookClientFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Jimmy. 2018/6/3  12:48
 * name="book-server" 调用的微服务接口所在的服务名
 * path = "book"
 */
@FeignClient(name="book-server",fallback = BookClientFallbackService.class)
@Service
public interface BookClient {

    @GetMapping("/book")
    String book();
}

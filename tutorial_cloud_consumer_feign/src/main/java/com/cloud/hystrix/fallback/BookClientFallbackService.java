package com.cloud.hystrix.fallback;

import com.cloud.controller.BookClient;
import org.springframework.stereotype.Component;

/**
 * Created by Jimmy. 2018/6/4  15:32
 */
@Component
public class BookClientFallbackService implements BookClient {
    @Override
    public String book() {
        return "book fall back";
    }
}

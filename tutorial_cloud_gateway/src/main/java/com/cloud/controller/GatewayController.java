package com.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jimmy. 2018/6/4  17:50
 */
@RestController
public class GatewayController {

    @GetMapping("/gatewayTest")
    public String gatewayTest(){
        return "gate way";
    }
}

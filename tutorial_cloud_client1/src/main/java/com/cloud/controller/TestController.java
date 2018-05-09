package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jimmy. 2018/5/9  17:58
 */
@RestController
public class TestController {

    @RequestMapping(value = "info")
    public String test(){
        return "hello 1";
    }
}

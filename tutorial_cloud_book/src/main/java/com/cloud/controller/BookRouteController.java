package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jimmy. 2018/6/5  21:22
 */
@RestController
@RequestMapping("/available")
public class BookRouteController {

    @RequestMapping("/bookRoute")
    public String bookRouteTest(){
        return "book-router";
    }
}

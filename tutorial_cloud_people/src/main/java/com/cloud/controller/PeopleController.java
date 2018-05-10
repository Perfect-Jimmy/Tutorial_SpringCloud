package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jimmy. 2018/5/10  17:29
 */
@RestController
public class PeopleController {

    @RequestMapping("people")
    public String peopleTest(){
        return "people";
    }
}

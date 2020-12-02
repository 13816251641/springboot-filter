package com.lujieni.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther lujieni
 * @Date 2020/6/12
 */
@RestController
public class HelloController {


    @GetMapping("/say/hello")
    public String hello(){

        return "hello";

    }


}

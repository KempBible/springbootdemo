package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TestController
 * @author: biankunpeng
 * @date: 2021年03月25日 14:51
 */
@RestController
public class TestController {

    @GetMapping("/hi")
    public String test(){
        System.out.println("123456");
        return "123";
    }
}

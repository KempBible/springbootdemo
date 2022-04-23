package com.example.springbootdemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 13:46
 */
@Component
public class MyService {

    public String data2() {
        return new SimpleDateFormat("yyyy-HH-dd HH:mm:ss").format(new Date());
    }

    @Async
    public String task1() {
        System.out.println("异步执行：" + Thread.currentThread().getName());
        task2();
        return "Async OK 1";
    }

    @Async
    public String task2() {
        System.out.println("异步执行：" + Thread.currentThread().getName());
        return "Async OK 2";
    }
}
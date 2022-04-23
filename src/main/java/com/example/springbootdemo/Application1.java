//package com.example.springbootdemo;
//
//import com.example.springbootdemo.service.MyService;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.scheduling.annotation.EnableAsync;
//
///**
// * @description:
// * @author: biankunpeng
// * @date: 2022/2/18 13:52
// */
//@EnableAsync
//@SpringBootApplication
//public class Application1 {// 测试使用
//
//    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(Application1.class, args);
//
//        MyService myService = context.getBean(MyService.class);
//        System.out.println("main线程执行开始..." + Thread.currentThread().getName());
//        myService.task1();
////        myService.task2();
//
//        System.out.println("main线程执行结束..." + Thread.currentThread().getName());
//    }
//}
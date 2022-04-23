//package com.example.springbootdemo;
//
//import com.example.springbootdemo.testService.A;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
///**
// * @description:
// * @author: biankunpeng
// * @date: 2022/2/18 13:52
// */
//@MapperScan("com.example.springbootdemo.mapper") //扫描的mapper
//@SpringBootApplication
//public class Application2 {// 测试使用
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.springbootdemo.testService");
//        A a = context.getBean(A.class);
//        a.sout();
//    }
//}
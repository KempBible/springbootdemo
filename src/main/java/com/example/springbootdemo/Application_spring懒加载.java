//package com.example.springbootdemo;
//
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
//public class Application_spring懒加载 {// 测试使用
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.springbootdemo.spring循环依赖");
////        A a = context.getBean(A.class);
////        a.sout();
//    }
//}
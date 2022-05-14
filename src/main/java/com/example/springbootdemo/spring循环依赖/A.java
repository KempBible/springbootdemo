//package com.example.springbootdemo.spring循环依赖;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @description:
// * @author: biankunpeng
// * @date: 2022/2/18 14:42
// */
//@Component
//public class A {
//
//    @Autowired
//    private B b;
//
//    public A(B b) {
//        this.b = b;
//    }
//
//    public void sout() {
//        System.out.println("===A===");
//    }
//}
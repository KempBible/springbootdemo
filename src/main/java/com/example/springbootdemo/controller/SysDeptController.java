//package com.example.springbootdemo.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Description: SysDeptController
// * @author: biankunpeng
// * @date: 2021年03月30日 20:35
// */
//@Slf4j
//@RestController
//@RequestMapping("/sysdept")
//public class SysDeptController {

//    @Autowired
//    SysDeptService sysDeptService;
//
//    @PostMapping("/add")
//    @ResponseBody
//    public void add(@RequestBody SysDept deptEntity) {
//        log.info("添加信息={}", deptEntity);
//        // 不再需要设置setCreateBy、setCreateTime、setUpdateBy、setUpdateTime操作，代码更优美
//        sysDeptService.add(deptEntity);
//    }
//}

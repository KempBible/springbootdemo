package com.example.springbootdemo.controller.swagger2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "订单模板")
@RestController("/orderController")
public class OrderController {

    @ApiOperation(value = "说明方法的作用", notes = "方法的备注说明")
    @GetMapping("/test")
    public String test() {
        System.out.println("当前线程名称" + Thread.currentThread().getName());
        return "test";
    }
}

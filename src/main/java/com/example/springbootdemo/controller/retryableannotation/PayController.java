package com.example.springbootdemo.controller.retryableannotation;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Retryable注解")
@RestController("/retryable")
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping("/retry")
    public String getNum() throws Exception{
        int i = payService.minGoodsnum(-1);
        System.out.println("===" + i);
        return "success";

    }
}

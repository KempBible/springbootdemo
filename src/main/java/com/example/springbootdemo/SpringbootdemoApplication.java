package com.example.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
// 添加注解
@EnableScheduling
// retryable 重试请求注解
//@EnableRetry
@SpringBootApplication
@MapperScan("com.example.springbootdemo.mapper") //扫描的mapper
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

//    @Scheduled(cron = "*/1 * * * * ? ")
//    public void task1(){
//      log.info("任务执行1..." + Thread.currentThread().getName());
//    }
//
//    @Scheduled(cron = "*/1 * * * * ? ")
//    public void task2(){
//        log.info("任务执行2..." + Thread.currentThread().getName());
//    }
}

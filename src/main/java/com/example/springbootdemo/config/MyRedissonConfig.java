//package com.example.springbootdemo.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
////https://blog.csdn.net/AP0906424/article/details/123178530
///**
// * @author biankunpeng
// * @date 2022/2/9 9:57
// */
//@Configuration
//public class MyRedissonConfig {
//
//    /**
//     * 所有对redisson的使用都是通过RedissonClient来操作的
//     * @return
//     */
//    @Bean(destroyMethod="shutdown")
//    public RedissonClient redisson(){
//        // 1. 创建配置
//        Config config = new Config();
//        // 一定要加redis://
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//        // 2. 根据config创建出redissonClient实例
//        RedissonClient redissonClient = Redisson.create(config);
//        return redissonClient;
//    }
//}
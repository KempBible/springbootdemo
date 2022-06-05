package com.example.springbootdemo.controller.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//https://blog.csdn.net/AP0906424/article/details/123178530
@RestController
public class RedissonController {

    @Autowired
    private Redisson redisson;

    @ResponseBody
    @GetMapping("/helloRedisson")
    public String hello(){
        // 1.获取一把锁，只要锁名字一样，就是同一把锁
        RLock lock = redisson.getLock("my-lock");
        // 2. 加锁
        lock.lock();// 阻塞试等待  默认加的都是30s
        // 带参数情况
        // lock.lock(10, TimeUnit.SECONDS);// 10s自动解锁，自动解锁时间一定要大于业务的执行时间。
        try {
            System.out.println("加锁成功" + Thread.currentThread().getId());
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 3. 解锁
            System.out.println("解锁成功：" + Thread.currentThread().getId());
            lock.unlock();
        }
        return "hello";
    }

}

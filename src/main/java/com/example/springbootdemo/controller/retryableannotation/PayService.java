package com.example.springbootdemo.controller.retryableannotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Slf4j
@Component
public class PayService {

    private final int totalNum = 10000;

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public int minGoodsnum(int num) throws Exception{
        log.info("减库存开始" + LocalTime.now());
        try {
            int i = 1 / 0;
        }catch (Exception e){
            log.error("illegal");
        }
        if (num <= 0){
            throw new IllegalArgumentException("数量不对");
        }
        log.info("减库存执行结束" + LocalTime.now());
        return totalNum - num;
    }

    @Recover
    public int recover(Exception e){
        log.warn("减库存失败！！！" + LocalTime.now());
        return totalNum;
    }
}

package com.example.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
public class JedisApplicationTests {

    @Autowired
    private JedisPool jedisPool;

    @Test
    public void contextLoads() {
        //在连接池中得到Jedis连接
        Jedis jedis = jedisPool.getResource();
        jedis.set("haha", "你好");
        jedis.set("name", "wangpengcheng");
        //关闭当前连接
        jedis.close();
    }
}
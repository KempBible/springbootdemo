package com.example.springbootdemo.controller.redis.jmeter;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//https://blog.csdn.net/zxd1435513775/article/details/122194202?spm=1001.2101.3001.6650.7&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-7-122194202-blog-105499233.pc_relevant_antiscanv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-7-122194202-blog-105499233.pc_relevant_antiscanv3&utm_relevant_index=12
public class RedisUtils {

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
    }

    public static Jedis getJedis() throws Exception{
        if(null != jedisPool){
            return jedisPool.getResource();
        }
        throw new Exception("JedisPool is not ok");
    }

}
package com.example.springbootdemo.controller.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;

//https://blog.csdn.net/qq_46550964/article/details/124388670
/**
 * explain: RedisTemplate操作string
 * public interface ValueOperations<K,V>
 * Redis operations for simple (or in Redis terminology 'string') values.
 * ValueOperations可以对String数据结构进行操作
 */
@RestController
@RequestMapping(value = "redisTemplate", produces = "application/json;charset=UTF-8")
public class RedisOperateStringController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    /**
     * RedisTemplate操作string
     */
    @GetMapping("/operateString")
    private String operateString() {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        //清空redis
        deleteAllKey();

        //void set(K key, V value);
        opsForValue.set("key1", "cat");
        System.out.println(opsForValue.get("key1"));

        //void set(K key, V value, long timeout, TimeUnit unit);
        //由于设置的是10秒失效，十秒之内查询有结果，十秒之后返回为null
        opsForValue.set("key2", "tom", 10, TimeUnit.SECONDS);
        Object key2 = opsForValue.get("key2");
        System.out.println(key2);

        // multiSet void multiSet(Map<? extends K, ? extends V> m);为多个键分别设置它们的值
        Map<String, String> maps = new HashMap<>();
        maps.put("multiKey1", "multi11");
        maps.put("multiKey2", "multi22");
        maps.put("multiKey3", "multi33");
        opsForValue.multiSet(maps);

        Set<String> keyList = maps.keySet();
        // List<String> keyList = new ArrayList<>(maps.keySet());
        List<Object> list = opsForValue.multiGet(keyList);
        System.out.println(list);

        // getAndSet V getAndSet(K key, V value); 设置键的字符串值并返回其旧值
        opsForValue.set("multiKey4", "multi44");
        System.out.println(opsForValue.getAndSet("multiKey4", "multi"));

        // multiSetIfAbsent Boolean multiSetIfAbsent(Map<? extends K, ? extends V> m);
        // 为多个键分别设置它们的值，如果存在则返回false，不存在返回true
        Boolean aBoolean = opsForValue.multiSetIfAbsent(maps);
        System.out.println(aBoolean);

        // multiGet List<V> multiGet(Collection<K> keys);为多个键分别取出它们的值
        ArrayList<String> keyLists = new ArrayList<>();
        keyLists.add("key1");
        keyLists.add("key2");
        keyLists.add("multiKey1");
        keyLists.add("multiKey2");
        keyLists.add("multiKey3");
        keyLists.add("multiKey4");

        List<Object> objects = opsForValue.multiGet(keyLists);
        System.out.println(objects);

        // increment Long increment(K key, long delta);支持整数
        Long longKey = opsForValue.increment("longKey", 99);
        System.out.println(longKey);
        System.out.println(opsForValue.get("longKey"));

        // increment Double increment(K key, double delta);也支持浮点数
        Double doubleKey = opsForValue.increment("doubleKey", 99.99);
        System.out.println(doubleKey);
        System.out.println(opsForValue.get("doubleKey"));

        // append Integer append(K key, String value);
        // 如果key已经存在并且是一个字符串，则该命令将该值追加到字符串的末尾。
        // 如果键不存在，则它被创建并设置为空字符串，因此APPEND在这种特殊情况下将类似于SET。
        // append()这里redisConfig使用jacksonRedisSerializer序列化方式时会出现序列化失败的情况,导致无法获取value
//        opsForValue.append("appendKye", "hello");
//        opsForValue.append("appendKye", "world ");
//        Object appendKye = opsForValue.get("appendKye");
//        System.out.println(appendKye);

        // get String get(K key, long start, long end);截取key所对应的value字符串
        opsForValue.set("key4", "HelloWorld");
        System.out.println(opsForValue.get("key4", 0, 4));
        System.out.println(opsForValue.get("key4", 0, -1));
        System.out.println(opsForValue.get("key4", 0, -6));

        // size Long size(K key); 返回key所对应的value值得长度
        Long key4 = opsForValue.size("key4");
        System.out.println(key4);

        return "method completed ok";
    }


    /**
     * 删除redis中所有的key
     */
    private void deleteAllKey() {
        //获取所有key
        Set<String> keys = redisTemplate.keys("*");
        System.out.println(keys);
        Long delete = redisTemplate.delete(keys);
        System.out.println(delete);
    }
}



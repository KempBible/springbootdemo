package com.example.springbootdemo.service.impl;


import com.example.springbootdemo.common.util.JedisUtils;
import com.example.springbootdemo.model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

//https://blog.csdn.net/wenkezhuangyuan/article/details/119430545
/**
 * @ClassName JedisServiceImpl
 * @Description TODO
 * @Author wpc
 * @Version 1.0
 */
@Service
@Log  //日志的处理
public class JedisServiceImpl {

    @Autowired
    private JedisUtils jedisUtils;

    /**
     * 测试String
     * 根据key 查询value值
     */
    public String getString(String key) {
        Jedis jedis = jedisUtils.getJedis();
        String val = null;
        if (!jedis.exists(key)) {
            val = "南京";
            log.info(key + "在MYSQL数据库中进行查询的结果是：" + val);
            jedis.set(key, val);
            log.info(key + "存入Redis中。值是：" + val);

        } else {
            val = jedis.get(key);
            log.info(key + "是在Redis中查询的数据。值是：" + val);
        }
        jedisUtils.close(jedis); //释放资源
        return val;
    }

    /**
     * 测试 jedis 操作hash类型
     * 根据用户ID查询用户信息
     * 先判断Redis中是否存在，
     * 如果不存在，数据库中查询。并存到Redis中
     * 如果存在，直接查询Redis 并返回
     */
    public User selectBy(String id) {
        String key = "user:id"; //根据规则生成相同规范的key
        User user = new User();

        Jedis jedis = jedisUtils.getJedis();
        if (!jedis.exists(key)) {
            //数据库中查询，并进行存
            user.setId(id);
            user.setUsername("JAVA");
            log.info("数据库中查询的用户信息是：" + user);
            Map<String, String> map = new HashMap();
            map.put("id", user.getId());
            map.put("name", user.getUsername());
            jedis.hset(key, map);
            log.info(key + "成功存入Redis:" + user);
        } else {
            Map<String, String> map = jedis.hgetAll(key);
            user.setId(map.get("id"));
            user.setUsername(map.get("name"));
            log.info(key + "Redis中查询出来的是:" + map);
        }
        jedisUtils.close(jedis);

        return user;
    }

}

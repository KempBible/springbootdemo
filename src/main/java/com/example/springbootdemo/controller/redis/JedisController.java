package com.example.springbootdemo.controller.redis;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.impl.JedisServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//https://blog.csdn.net/wenkezhuangyuan/article/details/119430545
@RestController
public class JedisController {

    @Autowired
    private JedisPool jedisPool;

    @PostMapping("/contextLoads")
    @ApiOperation(value = "使用Jedis连接redis，赋值")
    public void contextLoads() {
        System.out.println(jedisPool);
        //在连接池中得到Jedis连接
        Jedis jedis = jedisPool.getResource();
        jedis.set("haha", "你好");
        jedis.set("name", "wangpengcheng");
        //关闭当前连接
        jedis.close();
    }

    @Autowired
    private JedisServiceImpl jedisService;

    @PostMapping("/getRedisByKey")
    public String getRedisByKey() {
        String val = jedisService.getString("name");
        System.out.println(val);
        return val;
    }

    @PostMapping("/selectBy")
    public String selectBy(){
        User user= jedisService.selectBy("101");
        System.out.println(user);
        return user.toString();
    }
}

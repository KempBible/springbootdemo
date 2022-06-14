package com.example.springbootdemo.controller.redis.jmeter;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//https://blog.csdn.net/zxd1435513775/article/details/122194202?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-3-122194202-blog-124331083.pc_relevant_aa&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-3-122194202-blog-124331083.pc_relevant_aa&utm_relevant_index=6
@RestController
public class IndexController {

    @Autowired
    StringRedisTemplate template;

    @PostMapping(value = "/buy")
    public String index() {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Redis中存有goods:001号商品，数量为100
                    String result = template.opsForValue().get("goods:001");
                    // 获取到剩余商品数
                    int total = result == null ? 0 : Integer.parseInt(result);
                    if (total > 0) {
                        // 剩余商品数大于0 ，则进行扣减
                        int realTotal = total - 1;
                        // 将商品数回写数据库
                        template.opsForValue().set("goods:001", String.valueOf(realTotal));
                        System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
//                        return "购买商品成功，库存还剩："+realTotal +"件， 服务端口为8001";
                    } else {
                        System.out.println("购买商品失败，服务端口为8001");
                    }
                }
            }).start();
        }
        return "购买商品失败，服务端口为8001";
    }

    // 使用ReentrantLock锁解决单体应用的并发问题
    Lock lock = new ReentrantLock();

    @PostMapping("/buy2")
    public String buy2() {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        String result = template.opsForValue().get("goods:001");
                        int total = result == null ? 0 : Integer.parseInt(result);
                        if (total > 0) {
                            int realTotal = total - 1;
                            template.opsForValue().set("goods:001", String.valueOf(realTotal));
                            System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
//                        return "购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001";
                        } else {
                            System.out.println("购买商品失败，服务端口为8001");
                        }
                    } catch (Exception e) {
                        lock.unlock();
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
        return "购买商品失败，服务端口为8001";
    }

    // Redis分布式锁的key
    public static final String REDIS_LOCK = "good_lock";

    @PostMapping("/buy4")
    public String buy4() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 每个人进来先要进行加锁，key值为"good_lock"，value随机生成
                    String value = UUID.randomUUID().toString().replace("-", "");
                    try {
                        // 加锁
                        Boolean flag = template.opsForValue().setIfAbsent(REDIS_LOCK, value);
                        // 加锁失败
                        if (!flag) {
                            System.out.println("抢锁失败！");
                        }
                        System.out.println(value + " 抢锁成功");
                        String result = template.opsForValue().get("goods:001");
                        int total = result == null ? 0 : Integer.parseInt(result);
                        if (total > 0) {
                            int realTotal = total - 1;
                            template.opsForValue().set("goods:001", String.valueOf(realTotal));
                            // 如果在抢到所之后，删除锁之前，发生了异常，锁就无法被释放，
                            // 释放锁操作不能在此操作，要在finally处理
                            // template.delete(REDIS_LOCK);
                            System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
                        } else {
                            System.out.println("购买商品失败，服务端口为8001");
                        }
                    } finally {
                        // 释放锁
                        template.delete(REDIS_LOCK);
                    }
                }
            }).start();

        }
        return "ok";
    }

    @PostMapping("/buy5")
    public String buy5() {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 每个人进来先要进行加锁，key值为"good_lock"，value随机生成
                    String value = UUID.randomUUID().toString().replace("-", "");
                    try {
                        // 加锁
                        Boolean flag = template.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS);
                        // 加锁失败
                        if (!flag) {
                            System.out.println("抢锁失败！");
                        }
                        System.out.println(value + " 抢锁成功");
                        String result = template.opsForValue().get("goods:001");
                        int total = result == null ? 0 : Integer.parseInt(result);
                        if (total > 0) {
                            int realTotal = total - 1;
                            template.opsForValue().set("goods:001", String.valueOf(realTotal));
                            // 如果在抢到所之后，删除锁之前，发生了异常，锁就无法被释放，
                            // 释放锁操作不能在此操作，要在finally处理
                            // template.delete(REDIS_LOCK);
                            System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
                        } else {
                            System.out.println("购买商品失败，服务端口为8001");
                        }
                    } finally {
                        // 释放锁
                        template.delete(REDIS_LOCK);
                    }
                }
            }).start();

        }
        return "ok";
    }

    @PostMapping("/buy6")
    public String buy6() {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 每个人进来先要进行加锁，key值为"good_lock"
                    String value = UUID.randomUUID().toString().replace("-", "");
                    try {
                        // 为key加一个过期时间
                        Boolean flag = template.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS);

                        // 加锁失败
                        if (!flag) {
                            System.out.println("抢锁失败！");
                        }
                        System.out.println(value + " 抢锁成功");
                        String result = template.opsForValue().get("goods:001");
                        int total = result == null ? 0 : Integer.parseInt(result);
                        if (total > 0) {
                            // 如果在此处需要调用其他微服务，处理时间较长。。。
                            int realTotal = total - 1;
                            template.opsForValue().set("goods:001", String.valueOf(realTotal));
                            System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
                        } else {
                            System.out.println("购买商品失败，服务端口为8001");
                        }
                    } finally {
                        // 谁加的锁，谁才能删除！！！！
                        if (template.opsForValue().get(REDIS_LOCK).equals(value)) {
                            template.delete(REDIS_LOCK);
                        }
                    }
                }
            }).start();
        }

        return "123:" + new Date();
    }

    @PostMapping("/buy7")
    public String buy7() {

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 每个人进来先要进行加锁，key值为"good_lock"
                    String value = UUID.randomUUID().toString().replace("-", "");
                    try {
                        // 为key加一个过期时间
                        Boolean flag = template.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS);
                        // 加锁失败
                        if (!flag) {
                            System.out.println("抢锁失败！");
                        }
                        System.out.println(value + " 抢锁成功");
                        String result = template.opsForValue().get("goods:001");
                        int total = result == null ? 0 : Integer.parseInt(result);
                        if (total > 0) {
                            // 如果在此处需要调用其他微服务，处理时间较长。。。
                            int realTotal = total - 1;
                            template.opsForValue().set("goods:001", String.valueOf(realTotal));
                            System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
                        } else {
                            System.out.println("购买商品失败，服务端口为8001");
                        }
                    } finally {
                        // 谁加的锁，谁才能删除，使用Lua脚本，进行锁的删除
                        Jedis jedis = null;
                        try {
                            jedis = RedisUtils.getJedis();

                            String script = "if redis.call('get',KEYS[1]) == ARGV[1] " +
                                    "then " +
                                    "return redis.call('del',KEYS[1]) " +
                                    "else " +
                                    "   return 0 " +
                                    "end";

                            Object eval = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));
                            if ("1".equals(eval.toString())) {
                                System.out.println("-----del redis lock ok....");
                            } else {
                                System.out.println("-----del redis lock error ....");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (null != jedis) {
                                jedis.close();
                            }
                        }
                    }
                }
            }).start();
        }
        return "" + new Date();
    }

    @PostMapping("/buy7_1")
    public String buy7_1(){

        // 每个人进来先要进行加锁，key值为"good_lock"
        String value = UUID.randomUUID().toString().replace("-","");
        try{
            // 为key加一个过期时间
            Boolean flag = template.opsForValue().setIfAbsent(REDIS_LOCK, value,10L,TimeUnit.SECONDS);
            // 加锁失败
            if(!flag){
                return "抢锁失败！";
            }
            System.out.println( value+ " 抢锁成功");
            String result = template.opsForValue().get("goods:001");
            int total = result == null ? 0 : Integer.parseInt(result);
            if (total > 0) {
                // 如果在此处需要调用其他微服务，处理时间较长。。。
                int realTotal = total - 1;
                template.opsForValue().set("goods:001", String.valueOf(realTotal));
                System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
                return "购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001";
            } else {
                System.out.println("购买商品失败，服务端口为8001");
            }
            return "购买商品失败，服务端口为8001";
        }finally {
            // 谁加的锁，谁才能删除，使用Lua脚本，进行锁的删除

            Jedis jedis = null;
            try{
                jedis = RedisUtils.getJedis();

                String script = "if redis.call('get',KEYS[1]) == ARGV[1] " +
                        "then " +
                        "return redis.call('del',KEYS[1]) " +
                        "else " +
                        "   return 0 " +
                        "end";

                Object eval = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));
                if("1".equals(eval.toString())){
                    System.out.println("-----del redis lock ok....");
                }else{
                    System.out.println("-----del redis lock error ....");
                }
            }catch (Exception e){

            }finally {
                if(null != jedis){
                    jedis.close();
                }
            }
        }
    }



    @Autowired
    Redisson redisson;

    @PostMapping("/buy8")
    public String buy8(){

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    RLock lock = redisson.getLock(REDIS_LOCK);
                    lock.lock();

                    // 每个人进来先要进行加锁，key值为"good_lock"
                    String value = UUID.randomUUID().toString().replace("-","");
                    try{
                        String result = template.opsForValue().get("goods:001");
                        int total = result == null ? 0 : Integer.parseInt(result);
                        if (total > 0) {
                            // 如果在此处需要调用其他微服务，处理时间较长。。。
                            int realTotal = total - 1;
                            template.opsForValue().set("goods:001", String.valueOf(realTotal));
                            System.out.println("购买商品成功，库存还剩：" + realTotal + "件， 服务端口为8001");
                        } else {
                            System.out.println("购买商品失败，服务端口为8001");
                        }
                    }finally {
                        if(lock.isLocked() && lock.isHeldByCurrentThread()){
                            lock.unlock();
                        }
                    }
                }
            }).start();
        }

        return "" + new Date();
    }

}

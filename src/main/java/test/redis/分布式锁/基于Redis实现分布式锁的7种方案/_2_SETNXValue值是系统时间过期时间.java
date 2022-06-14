package test.redis.分布式锁.基于Redis实现分布式锁的7种方案;

import redis.clients.jedis.Jedis;

//https://blog.csdn.net/weixin_46228112/article/details/124331083?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-0-124331083-blog-121318281.pc_relevant_default&spm=1001.2101.3001.4242.1&utm_relevant_index=3
public class _2_SETNXValue值是系统时间过期时间 {

    private static Jedis jedis = new Jedis("127.0.0.1", 6379, 100000); //redis客户端

    public static void main(String[] args) {
        System.out.println(lock());
    }

    public static boolean lock() {
        long expireTime = 10000;
        long expires = System.currentTimeMillis() + expireTime;
        String expiresStr = String.valueOf(expires);

        String key_resource_id_2 = "key_resource_id_2";

        // 如果当前锁不存在，返回加锁成功
        if (jedis.setnx(key_resource_id_2, expiresStr) == 1) {
            return true;
        }

        // 如果锁已经存在，获取锁的过期时间
        String currentValueStr = jedis.get(key_resource_id_2);

        // 如果获取到的过期时间，小于系统当前时间，表示已经过期
        if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()){
            // 锁已过期，获取上一个锁的过期时间，并设置现在锁的过期时间（不了解redis的getSet命令的小伙伴，可以去官网看下哈）
            String oldValueStr = jedis.getSet(key_resource_id_2, expiresStr);
            if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                // 考虑多线程并发的情况，只有一个线程的设置值和当前值相同，它才可以加锁
                return true;
            }
        }

        //其他情况，均返回加锁失败
        return false;
    }

}

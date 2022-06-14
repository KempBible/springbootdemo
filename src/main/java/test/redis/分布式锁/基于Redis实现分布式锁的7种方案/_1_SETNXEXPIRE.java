package test.redis.分布式锁.基于Redis实现分布式锁的7种方案;

import redis.clients.jedis.Jedis;

//https://blog.csdn.net/weixin_46228112/article/details/124331083?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-0-124331083-blog-121318281.pc_relevant_default&spm=1001.2101.3001.4242.1&utm_relevant_index=3
public class _1_SETNXEXPIRE {

    private static Jedis jedis = new Jedis("127.0.0.1", 6379,100000); //redis客户端

    public static void main(String[] args) {

        String key_resource_id = "key_resource_id";
        String lock_value = "lock_value";
        System.out.println("init:" + jedis.get(key_resource_id));

        if (jedis.setnx(key_resource_id, lock_value) == 1){
            jedis.expire(key_resource_id,100); //设置过期时间
            try {
                System.out.println(jedis.get(key_resource_id));
            }catch (Exception e){
                System.out.println(e);
            }finally {
                jedis.del(key_resource_id); //释放锁
            }
        }
    }
}

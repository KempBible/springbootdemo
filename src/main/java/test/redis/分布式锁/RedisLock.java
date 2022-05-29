package test.redis.分布式锁;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

//https://aobing.blog.csdn.net/article/details/105499233?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-105499233-blog-119251590.pc_relevant_antiscanv4&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-105499233-blog-119251590.pc_relevant_antiscanv4&utm_relevant_index=1
public class RedisLock {

    private String LOCK_KEY = "redis_lock"; //key
    private long INTERNAL_LOCK_LEASE_TIME = 3; //自动失效时间
    private long timeout = 1000; //超时时间还没拿到自动退出
    private SetParams params = SetParams.setParams().nx().px(INTERNAL_LOCK_LEASE_TIME); //nx px命令的合集
    private static Jedis jedis = new Jedis("127.0.0.1", 6379,100000); //redis客户端

    private static Integer inventory = 0;
    private static final int NUM = 1000;

    public RedisLock() {
    }

    public static void main(String[] args) {
        jedis.setnx("lock", "test");
//        try {
//            inventory = Integer.parseInt(jedis.get("inventory"));
//            for (int i = 0; i < NUM; i++) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        jedis.setnx("lock", "test");
//                        try {
//                            Thread.sleep(1);
//                            if (RedisLock.inventory > 0){
//                                RedisLock.inventory--;
//                            }
//                            System.out.println(RedisLock.inventory);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    /**
     * 加锁
     *
     * @param id
     * @return
     */
    public boolean lock(String id) {
        Long start = System.currentTimeMillis();
        try {
            for (; ; ) {
                //SET命令返回OK ，则证明获取锁成功
                String lock = jedis.set(LOCK_KEY, id, params);
                if ("OK".equals(lock)) {
                    return true;
                }
                //否则循环等待，在timeout时间内仍未获取到锁，则获取失败
                long l = System.currentTimeMillis() - start;
                if (l >= timeout) {
                    return false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            jedis.close();
        }
    }

    /**
     * 解锁
     *
     * @param id
     * @return
     */
    public boolean unlock(String id) {
        String script =
                "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        try {
            String result = jedis.eval(script, Collections.singletonList(LOCK_KEY), Collections.singletonList(id)).toString();
            return "1".equals(result) ? true : false;
        } finally {
            jedis.close();
        }
    }


}

package test.redis.分布式锁;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class RedisTestLock {

    private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
    static RedisLock redisLock = new RedisLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, linkedBlockingDeque);

        long start = System.currentTimeMillis();

        for (int i = 0; i <= 3; i++) {
            threadPoolExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    redisLock.lock(UUID.randomUUID().toString());
                    inventory--;
                    System.out.println("线程执行：" + Thread.currentThread().getName());
                    redisLock.unlock(UUID.randomUUID().toString());
                }
            });
        }
        threadPoolExecutor.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("执行线程数：" + NUM + " 总耗时：" + (end - start) + " 库存数为：" + inventory);
    }
}

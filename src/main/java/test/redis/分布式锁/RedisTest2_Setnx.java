package test.redis.分布式锁;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//https://aobing.blog.csdn.net/article/details/105499233?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-105499233-blog-119251590.pc_relevant_antiscanv4&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-105499233-blog-119251590.pc_relevant_antiscanv4&utm_relevant_index=1
public class RedisTest2_Setnx {
    private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, linkedBlockingDeque);

        final CountDownLatch countDownLatch = new CountDownLatch(NUM);
        long start = System.currentTimeMillis();

        for (int i = 0; i <= NUM; i++) {
            threadPoolExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    inventory--;
                    System.out.println("线程执行：" + Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            });
        }
        threadPoolExecutor.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("执行线程数：" + NUM + " 总耗时：" + (end - start) + " 库存数为：" + inventory);
    }

}

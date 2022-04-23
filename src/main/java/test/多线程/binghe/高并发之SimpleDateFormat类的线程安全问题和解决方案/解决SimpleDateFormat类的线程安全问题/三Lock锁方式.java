package test.多线程.binghe.高并发之SimpleDateFormat类的线程安全问题和解决方案.解决SimpleDateFormat类的线程安全问题;

//https://mp.weixin.qq.com/s?__biz=Mzg4MjU0OTM1OA==&mid=2247489403&idx=1&sn=b617f8de94f8db91b3a38fe154fcd933&chksm=cf55a07af822296c61b4d7114e252c4f49dfd9e49739ef6900d7ff66bf4a0b0b7713c7a596ae&cur_album_id=1659019088070803460&scene=189#wechat_redirect

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过Lock锁解决SimpleDateFormat类的线程安全问题
 */
public class 三Lock锁方式 {
    //执行总次数
    private static final int EXECUTE_COUNT = 1000;
    //同时运行的线程数量
    private static final int THREAD_COUNT = 20;
    // SimpleDateFormat对象
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //Lock对象
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(THREAD_COUNT);
        final CountDownLatch countDownLatch = new CountDownLatch(EXECUTE_COUNT);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < EXECUTE_COUNT; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    try {
                        lock.lock();
                        simpleDateFormat.parse("2022-04-19");
                    }catch (ParseException e) {
                        System.out.println("线程：" + Thread.currentThread().getName() + " 格式化日期失败");
                        e.printStackTrace();
                        System.exit(1);
                    }catch (NumberFormatException e){
                        System.out.println("线程：" + Thread.currentThread().getName() + " 格式化日期失败");
                        e.printStackTrace();
                        System.exit(1);
                    }finally {
                        lock.unlock();
                    }
                    semaphore.release();
                } catch (NumberFormatException | InterruptedException e){
                    System.out.println("线程：" + Thread.currentThread().getName() + " 格式化日期失败");
                    e.printStackTrace();
                    System.exit(1);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("所有线程格式话日期成功");
    }
}

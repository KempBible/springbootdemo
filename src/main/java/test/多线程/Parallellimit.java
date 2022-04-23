package test.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Parallellimit
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/6 15:58
 */
// https://www.jianshu.com/p/e233bb37d2e6
public class Parallellimit {
    // 先阅读CountDownLatchTest

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch cd1 = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable countRunnable = new CountRunnable(cd1);
            executorService.execute(countRunnable);
        }
    }


}

class CountRunnable implements Runnable {
    private CountDownLatch countDownLatch;

    public CountRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            synchronized (countDownLatch) {
                /*** 每次减少一个容量*/
                countDownLatch.countDown();
                System.out.println("thread counts = " + (countDownLatch.getCount()));
            }
            countDownLatch.await();
            System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package test.多线程.lock2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SynchronizedDemo
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/11 11:19
 */
public class SynchronizedDemo implements Runnable {

    //    private volatile static int count = 0;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result:" + count);
    }

    @Override
    public void run() {
//        synchronized (SynchronizedDemo.class){
        for (int i = 0; i < 1000000; i++) {
            add();
        }
//        }
    }

    private static void add() {
        count.incrementAndGet();
    }
}

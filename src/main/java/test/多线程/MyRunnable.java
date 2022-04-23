package test.多线程;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/4 14:32
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "-------------进入");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(currentThread.getName() + "-------------离开");
        }
    }
}
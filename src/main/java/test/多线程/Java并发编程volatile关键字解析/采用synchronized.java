package test.多线程.Java并发编程volatile关键字解析;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 18:46
 */
public class 采用synchronized {


    public static int inc = 0;
    static Lock lock = new ReentrantLock();

    public static void increase() {
        lock.lock();
        inc++;
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increase();
                    System.out.println(inc);
                }
            }).start();
        }

    }
}
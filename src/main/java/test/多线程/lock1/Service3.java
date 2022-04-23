package test.多线程.lock1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName getWaitQueueLength
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 10:46
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service3 {
    /***
     * 作用是返回等待与此锁相关的给定条件Condition的线程估计数。
     * 如5个线程，每一个线程都执行了同一个condition对象的await（）方法
     * 则调用getWaitQueueLength( Condition condition) 返回的值int为5
     **/
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void methodA() {
        try {
            lock.lock();
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void methodB() {
        try {
            lock.lock();
            System.out.println("有1 " + lock.getWaitQueueLength(condition) + " 正在等condition");
//            condition.signal();
            condition.signalAll();
            System.out.println("有2 " + lock.getWaitQueueLength(condition) + " 正在等condition");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                methodA();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread.sleep(2000);
        methodB();
    }
}

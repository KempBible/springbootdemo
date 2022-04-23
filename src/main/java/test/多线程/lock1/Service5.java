package test.多线程.lock1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service5
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 11:09
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service5 {
    /**
     * boolean  hasWaiters(Condition condition )
     * 作用就是查询是否有线程正在等待与此锁定有关的condition
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
            System.out.println("begin 有" + lock.hasWaiters(condition) + " 线程数是 " + lock.getWaitQueueLength(condition));
            condition.signal();
            System.out.println("end 有" + lock.hasWaiters(condition) + " 线程数是 " + lock.getWaitQueueLength(condition));
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

package test.多线程.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service10
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 16:05
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service10 {
    static ReentrantLock lock = new ReentrantLock();

    public static void methodA() {
        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + "获得锁");
        } else {
            System.out.println(Thread.currentThread().getName() + "没有获得锁");
        }
    }

    //结果是不定的
    public static void main(String[] args) {
        final Service10 service10 = new Service10();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service10.methodA();
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.setName("A");
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.setName("B");
        thread2.start();
    }
}

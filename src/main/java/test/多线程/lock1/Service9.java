package test.多线程.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service9
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 15:49
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service9 {
    static ReentrantLock lock = new ReentrantLock();

    public static void methodA() {
        try {
            lock.lockInterruptibly();
            System.out.println("线程 begin " + Thread.currentThread().getName());
            for (int i = 0; i < 10000; i++) {
                String s = new String();
                Math.random();
            }
            System.out.println("线程 end" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println("线程 " + Thread.currentThread().getName() + " 释放锁");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    public static void test1() throws InterruptedException {
        final Service9 service9 = new Service9();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service9.methodA();
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("A");
        thread1.start();
        Thread.sleep(2);
        Thread thread2 = new Thread(runnable);
        thread2.setName("B");
        thread2.start();
        // 线程B获得锁，但是被中断，抛出异常
//        thread2.interrupt();
        Thread.sleep(1000);
        System.out.println("end main");
    }

}

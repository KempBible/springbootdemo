package test.多线程.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service7
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 11:26
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service7 {
    // boolean  isHeldByCurrentThread() 查询当前线程是否保存此锁定
    private static ReentrantLock lock = null;

    public Service7(Boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public static void methodA() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println("线程lock begin" + name + " " + lock.isHeldByCurrentThread());
            lock.lock();
            System.out.println("线程lock end" + name + " " + lock.isHeldByCurrentThread());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Service7(true).methodA();
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("A");
        thread1.start();
        Thread.sleep(500);
        Thread thread2 = new Thread(runnable);
        thread2.setName("B");
        thread2.start();
    }

}

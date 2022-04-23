package test.多线程.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service4
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 11:02
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
// 方法hasQueueThread() 、hasQueueThreads 、hasWaiters()
public class Service4 {
    /**
     * （一）、hasQueueThread()
     * boolean   hasQueueThread(Thread thread) 查询指定的线程
     * 是否正在等待获取此锁定。
     * boolean   hasQueueThreads(Thread thread) 查询是否有线程正在等待
     * 获取此锁定。
     **/
    static ReentrantLock lock = new ReentrantLock();

    public static void methodA() {
        try {
            lock.lock();
            System.out.println("线程 " + Thread.currentThread().getName() + " 进入方法");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        Thread thread1 = new Thread(runnable);
        thread1.setName("A");
        thread1.start();
        Thread.sleep(500);
        Thread thread2 = new Thread(runnable);
        thread2.setName("B");
        thread2.start();
        Thread.sleep(500);
        System.out.println("t1 " + lock.hasQueuedThread(thread1));
        System.out.println("t2 " + lock.hasQueuedThread(thread2));
        System.out.println("哈哈：" + lock.hasQueuedThreads());
    }
}

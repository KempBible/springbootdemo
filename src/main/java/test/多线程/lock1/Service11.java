package test.多线程.lock1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service11
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 16:10
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service11 {
    private ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " " + "获取锁时间 " + System.currentTimeMillis());
                Thread.sleep(8000);
            } else {
                System.out.println(Thread.currentThread().getName() + " " + "没有获取锁时间" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println(Thread.currentThread().getName() + " " + "释放锁时间" + System.currentTimeMillis());
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final Service11 service11 = new Service11();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 调用methodA时间" + System.currentTimeMillis());
                service11.methodA();
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

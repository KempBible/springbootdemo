package test.多线程.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service2
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 10:33
 */
//https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service2 {

    /**
     * 作用是返回正等待获取此锁定的线程估计数。
     * 比如有5个线程，一个线程先执行await(),那么在调用getQueueLength（）时
     * 返回值是4，说明有4个线程在等待lock的释放。n
     **/
    public static ReentrantLock lock = new ReentrantLock();

    public static void methodA() {
        try {
            lock.lock();
            System.out.println("线程 " + Thread.currentThread().getName() + " 进入了方法");
//            Thread.sleep(5000);
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
                System.out.println("**线程 " + Thread.currentThread().getName() + " 运行了");
                methodA();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
            threads[i].setName("" + (i + 1));
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread.sleep(2000);
        System.out.println("正有 " + lock.getQueueLength() + " 个线程等待获取锁");
    }

}

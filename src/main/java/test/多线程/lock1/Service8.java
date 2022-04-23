package test.多线程.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service8
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 15:32
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service8 {
    /**
     * boolean isLocked()
     * 查询此锁定是否是由任意线程保持
     **/
    static ReentrantLock lock = null;

    public Service8(Boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public static void methodA() {
        try {
            System.out.println(lock.isLocked());
            lock.lock();
            System.out.println(lock.isLocked());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Service8(false).methodA();
            }
        };
        new Thread(runnable).start();
    }

}

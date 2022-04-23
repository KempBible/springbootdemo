package test.多线程.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service6
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 11:19
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service6 {
    /**
     * 方法isFair() 、isHeldByCurrentThread()、 isLocked()
     * （一）
     * boolean  isFair() 判断是不是公平锁
     **/
    static ReentrantLock lock = null;

    public Service6(Boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public static void methodA() {
        try {
            lock.lock();
            System.out.println("是不是公平锁" + lock.isFair());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Service6(true).methodA();
        new Service6(false).methodA();
    }
}

package test.多线程.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service1
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 10:24
 */
//https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service1 {
    /**
     * 一 、getHoldCount() 、getQueueLength()、getWaitQueueLength()
     * (一)、getHoldCount() 是当前线程调用lock方法的次数。
     **/
    private static ReentrantLock lock = new ReentrantLock();

    private static void methodA() {
        lock.lock();
        System.out.println("methodA getHoldCount " + lock.getHoldCount());
        methodB();
        lock.unlock();
    }

    private static void methodB() {
        lock.lock();
        System.out.println("methodB getHoldCount " + lock.getHoldCount());
        lock.unlock();
    }

    public static void main(String[] args) {
        methodA();
    }

}

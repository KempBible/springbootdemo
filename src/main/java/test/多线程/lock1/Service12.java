package test.多线程.lock1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service12
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 16:25
 */
// https://www.cnblogs.com/lanpo/articles/12001387.html
public class Service12 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void methodA() {
        try {
            lock.lock();
            System.out.println("await begin...");
            condition.await();
            System.out.println("await end...");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("catch lanpo...");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Service12 service12 = new Service12();
        Thread thread1 = new Thread((Runnable) service12);
    }
}

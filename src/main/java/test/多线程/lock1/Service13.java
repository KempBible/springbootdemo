package test.多线程.lock1;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Service13
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 16:31
 */
public class Service13 {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public void methodA() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            reentrantLock.lock();
            System.out.println("methodA wait begin time" + System.currentTimeMillis());
            condition.awaitUntil(calendar.getTime());
            System.out.println("methodA wait end time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void methodB() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            reentrantLock.lock();
            System.out.println("methodB wait begin time " + System.currentTimeMillis());
            condition.signalAll();
            System.out.println("methodB wait end time" + System.currentTimeMillis());
        } finally {
            reentrantLock.unlock();
        }
    }
}

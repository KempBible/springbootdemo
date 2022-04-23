package test.多线程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOddLock {
    private int n;
    Lock lock = new ReentrantLock();

    /*控制zero线程，打印一下，卡顿一下*/
    Condition condition1 = lock.newCondition();

    public ZeroEvenOddLock(int n) {
        this.n = n;
    }

    final Object LOCK = new Object();
    volatile int x = 0;
    static final int count = 2;

    final CountDownLatch latch = new CountDownLatch(count);

    //控制打印奇数的线程 比 打印偶数的线程 先开始 或者说 奇数线程 先获取 LOCK
    volatile boolean evenStart = false;

    Semaphore semaphoreZero = new Semaphore(1);
    Semaphore semaphore = new Semaphore(1);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        printNumber.accept(0);
        x++;
        for (int i = 0; /*i <= latch.getCount()*/ i < count; i++) {
            latch.countDown();
        }
        try {
            for (int i = 0; i < n - 1; i++) {
                //这两步 使zero 抱着semaphoreZero睡觉
                semaphoreZero.acquire();
                condition1.await();
                x++;
                printNumber.accept(0);

                semaphoreZero.release();
                semaphore.acquire();
                semaphore.release();
            }
        } finally {
            lock.unlock();
        }
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        latch.await();
        while (!evenStart) {
        }
        synchronized (LOCK) {
            for (; ; ) {
                if (x == n) {
                    LOCK.notifyAll();
                    break;
                }
                printNumber.accept(x);
                lock.lock();
                try {
                    semaphore.acquire();
                    condition1.signalAll();
                } finally {
                    lock.unlock();
                }
                semaphoreZero.acquire();
                LOCK.notifyAll();
                semaphoreZero.release();
                semaphore.release();
                LOCK.wait();

            }
        }
        if ((n & 1) == 0) {
            printNumber.accept(n);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        latch.await();

        Object o = new Object();
        o.wait();

        synchronized (LOCK) {
            //odd 第一次先于 even 拿到锁了
            evenStart = true;
            for (; ; ) {
                if (x == n) {
                    LOCK.notifyAll();
                    break;
                }
                printNumber.accept(x);
                lock.lock();
                try {
                    semaphore.acquire();
                    condition1.signalAll();
                } finally {
                    lock.unlock();
                }
                semaphoreZero.acquire();
                LOCK.notifyAll();
                semaphoreZero.release();
                semaphore.release();
                LOCK.wait();

            }
        }
        if ((n & 1) == 1) {
            printNumber.accept(n);
        }
    }
}
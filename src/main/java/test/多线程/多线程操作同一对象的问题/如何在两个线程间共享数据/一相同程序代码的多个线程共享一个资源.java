package test.多线程.多线程操作同一对象的问题.如何在两个线程间共享数据;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 15:12
 */
public class 一相同程序代码的多个线程共享一个资源 {
    public static void main(String[] args) {
        //创建线程任务对象

        Ticket ticket = new Ticket();
        //创建三个窗口对象
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");
        //卖票
        t1.start();
        t2.start();
        t3.start();
    }

    static class Ticket implements Runnable {
        //Object lock = new Object();
        ReentrantLock lock = new ReentrantLock();
        private int ticket = 10;

        public void run() {
            String name = Thread.currentThread().getName();
            while (true) {
                sell(name);
                if (ticket <= 0) {
                    break;
                }
            }
        }

        private synchronized void sell(String name) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0) {
                System.out.println(name + "卖票：" + ticket);
                ticket--;
            }
        }
    }
}
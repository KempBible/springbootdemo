package test.多线程.Java并发编程volatile关键字解析;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 18:21
 */

public class volatile保证原子性吗 {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final volatile保证原子性吗 test = new volatile保证原子性吗();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }

                ;
            }.start();
        }

        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
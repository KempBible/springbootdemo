package test.多线程.多线程操作同一对象的问题;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 14:50
 */
// 多个线程操作同一个对象的情况下，线程不安全，数据紊乱
// https://www.jianshu.com/p/c7074316d225
public class 抢票代码改进版 implements Runnable {
    private int ticketNum = 10;
    private boolean isLoack = false;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 1) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!isLoack) {
                System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum-- + "票");
                isLoack = true;
            }
            isLoack = false;
        }
    }

    public static void main(String[] args) {
        抢票代码改进版 tt = new 抢票代码改进版();
        new Thread(tt, "小明").start();
        new Thread(tt, "小红").start();
        new Thread(tt, "小强").start();
    }
}
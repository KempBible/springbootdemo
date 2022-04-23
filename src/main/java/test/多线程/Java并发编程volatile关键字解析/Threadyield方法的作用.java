package test.多线程.Java并发编程volatile关键字解析;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 19:17
 */
public class Threadyield方法的作用 extends Thread {

    public Threadyield方法的作用(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            if (i == 30) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        Threadyield方法的作用 yt1 = new Threadyield方法的作用("张三");
        Threadyield方法的作用 yt2 = new Threadyield方法的作用("李四");
        yt1.start();
        yt2.start();
    }
}
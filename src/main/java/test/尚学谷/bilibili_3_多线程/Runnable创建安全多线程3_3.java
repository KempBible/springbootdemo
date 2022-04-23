package test.尚学谷.bilibili_3_多线程;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 * 1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
 * 2.非静态的同步方法，同步监视器是：this
 *   静态的同步方法，同步监视器是：当前类本身
 *
 */
public class Runnable创建安全多线程3_3 implements Runnable{
    private int ticket = 100;

    @Override
    public synchronized void run() {
        while (true){
            show();
        }
    }

    private synchronized void show(){ // 同步监视器this
        if (ticket > 0){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {
        Runnable创建安全多线程3_3 runnable创建安全多线程3_1 = new Runnable创建安全多线程3_3();

        Thread thread1 = new Thread(runnable创建安全多线程3_1);
        Thread thread2 = new Thread(runnable创建安全多线程3_1);
        Thread thread3 = new Thread(runnable创建安全多线程3_1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

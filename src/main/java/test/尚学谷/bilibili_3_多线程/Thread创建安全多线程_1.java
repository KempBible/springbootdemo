package test.尚学谷.bilibili_3_多线程;

/**
 * 使用同步代码块解决继承Thread类的方式的多线程安全问题
 *
 */
public class Thread创建安全多线程_1 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private static synchronized void show(){ // 同步监视器:window4.class
//        private synchronized void show(){ // 同步监视器t1、t2、t3 此种解决方法是错误的
        if (ticket > 0){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }

    public static void main(String[] args) {
        Thread创建安全多线程_1 thread创建安全多线程1 = new Thread创建安全多线程_1();
        Thread创建安全多线程_1 thread创建安全多线程2 = new Thread创建安全多线程_1();
        Thread创建安全多线程_1 thread创建安全多线程3 = new Thread创建安全多线程_1();

        thread创建安全多线程1.setName("窗口1");
        thread创建安全多线程2.setName("窗口2");
        thread创建安全多线程3.setName("窗口3");

        thread创建安全多线程1.start();
        thread创建安全多线程2.start();
        thread创建安全多线程3.start();
    }
}

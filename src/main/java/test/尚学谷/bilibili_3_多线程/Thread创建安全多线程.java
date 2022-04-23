package test.尚学谷.bilibili_3_多线程;

/**
 * 使用同步代码块解决继承Thread类的方式的多线程安全问题
 * 例子：创建三个窗口卖票，总票数为100张，使用继承Thread类的方式
 * 存在线程的安全问题，待解决
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 */
public class Thread创建安全多线程 extends Thread {

    private static int ticket = 100;
    // 这样写线程不安全，对象变量
//    private Object obj = new Object();
    private static Object obj = new Object();

    @Override
    public void run() {

        while(true){
//            synchronized (this){ // 错误的写法，this代表着窗口1、窗口2、窗口3三个对象
//            synchronized (obj){
            synchronized (Thread创建安全多线程.class){ // Class clazz = Thread创建安全多线程.class
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread创建安全多线程 thread创建安全多线程1 = new Thread创建安全多线程();
        Thread创建安全多线程 thread创建安全多线程2 = new Thread创建安全多线程();
        Thread创建安全多线程 thread创建安全多线程3 = new Thread创建安全多线程();

        thread创建安全多线程1.setName("窗口1");
        thread创建安全多线程2.setName("窗口2");
        thread创建安全多线程3.setName("窗口3");

        thread创建安全多线程1.start();
        thread创建安全多线程2.start();
        thread创建安全多线程3.start();
    }
}

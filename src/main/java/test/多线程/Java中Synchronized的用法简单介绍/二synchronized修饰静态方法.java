package test.多线程.Java中Synchronized的用法简单介绍;

public class 二synchronized修饰静态方法 {
    public static void main(String[] args) {
        System.out.println("使用关键字静态synchronized");
        SyncThread3 syncThread3 = new SyncThread3();
        Thread thread1 = new Thread(syncThread3, "SyncThread1");
        Thread thread2 = new Thread(syncThread3, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}

class SyncThread3 implements Runnable{
    private static int count;

    public SyncThread3() {
        count = 0;
    }

    @Override
    public synchronized void run() {
        method();
    }

    private synchronized static void method() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

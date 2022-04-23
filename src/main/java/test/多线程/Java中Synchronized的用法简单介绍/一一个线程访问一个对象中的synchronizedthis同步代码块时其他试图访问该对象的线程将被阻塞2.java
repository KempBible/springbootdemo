package test.多线程.Java中Synchronized的用法简单介绍;

public class 一一个线程访问一个对象中的synchronizedthis同步代码块时其他试图访问该对象的线程将被阻塞2 {
    public static void main(String[] args) {
        System.out.println("使用关键字synchronized每次调用进行new SyncThread()");
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}

class SyncThread2 implements Runnable {
    private static int count;
    public SyncThread2() {
        count = 0;
    }
    public  void run() {
        // 有问题
//        synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("线程名:"+Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//        }
    }
    public int getCount() {
        return count;
    }
}
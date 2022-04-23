package test.多线程.Java中Synchronized的用法简单介绍;

public class 二修饰一个方法 {
    public static void main(String[] args) {
        System.out.println("使用关键字synchronized每次调用进行new SyncThread()");
        Thread thread1 = new Thread(new Mthreads2(), "Mthreads21");
        Thread thread2 = new Thread(new Mthreads2(), "Mthreads22");
        thread1.start();
        thread2.start();
    }
}

class Mthreads2 implements Runnable{

    private volatile static int count;
    public Mthreads2() {
        count = 0;
    }
    public synchronized void run() {
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("线程名:"+Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public int getCount() {
        return count;
    }
}
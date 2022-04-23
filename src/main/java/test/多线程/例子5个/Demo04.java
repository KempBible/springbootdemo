package test.多线程.例子5个;

class SyncThread2 implements Runnable {

    private static int count;

    public SyncThread2() {
        count = 0;
    }

    public static void method() {
        synchronized (SyncThread.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public synchronized void run() {
        method();
    }
}

public class Demo04 {
    public static void main(String[] args) {
        SyncThread2 syncThread1 = new SyncThread2();
        Thread thread1 = new Thread(syncThread1);
        Thread thread2 = new Thread(syncThread1);
        thread1.start();
        thread2.start();
    }
}

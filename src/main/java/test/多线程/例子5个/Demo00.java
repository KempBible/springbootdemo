package test.多线程.例子5个;

class SyncThread implements Runnable {
    private static int count;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getCount() {
        return count;
    }
}

public class Demo00 {
    public static void main(String[] args) {
        // test01
//        SyncThread s1 = new SyncThread();
//        SyncThread s2 = new SyncThread();
//        Thread t1 = new Thread(s1);
//        Thread t2 = new Thread(s2);
//
//        t1.start();
//        t2.start();

        // test02
        SyncThread s = new SyncThread();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);

        t1.start();
        t2.start();
    }
}

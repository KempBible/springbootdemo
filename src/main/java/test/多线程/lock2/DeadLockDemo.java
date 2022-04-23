package test.多线程.lock2;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/11 9:54
 */
// https://www.cnblogs.com/lanpo/articles/12076599.html
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        deadLock();
    }

    private static void deadLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("thread2");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("thread2");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }


}

package test.多线程;

public class SynchronizedClassStatic4 implements Runnable {

    public static void main(String[] args) {
        SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();
        SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("Finished");
    }

    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("我是类锁的第一种形式，static形式，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束");
    }
}

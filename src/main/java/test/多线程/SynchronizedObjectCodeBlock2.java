package test.多线程;

public class SynchronizedObjectCodeBlock2 implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            // Thread.currentThread() 当前线程，.getName（）名字
            System.out.println("我是对象锁的代码块形式我叫" + Thread.currentThread().getName());

            try {
                // 让当前线程休眠3秒
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        System.out.println("finish");
    }
}

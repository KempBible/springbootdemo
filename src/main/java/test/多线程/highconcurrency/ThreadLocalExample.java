package test.多线程.highconcurrency;

/**
 * @Description: ThreadLocalExample
 * @author: biankunpeng
 * @date: 2021年04月15日 21:43
 */
public class ThreadLocalExample  {
    public static class MyRunnable implements Runnable {
    private ThreadLocal threadLocal = new ThreadLocal();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println(threadLocal.get());
    }

}
    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }
}

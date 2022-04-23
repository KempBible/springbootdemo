package test.jvm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName PlusTaskTest
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/14 10:38
 */
public class PlusTaskTest {

    //    static volatile int i = 0;
    static AtomicInteger i = new AtomicInteger(0);

    public static class PlusTask implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                int tmp = i.get();
                i.compareAndSet(tmp, ++tmp);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(i);
    }

}

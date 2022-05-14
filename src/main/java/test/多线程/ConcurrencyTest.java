package test.多线程;

public class ConcurrencyTest {

    private static final long count = 100000000L;

    public static void main(String[] args) throws InterruptedException {
        concurrent();
        serial();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        long endTime = System.currentTimeMillis() - start;
        System.out.println("串行endTime " + endTime + " ms b = " + b + " a = " + a);
    }

    private static void concurrent() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                System.out.println("线程内 " + Thread.currentThread().getName());
                for (int i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        System.out.println("线程外 " + Thread.currentThread().getName());
        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long endTime = System.currentTimeMillis() - start;
        System.out.println("并发endTime" + endTime + " ms b = " + b);
    }

}

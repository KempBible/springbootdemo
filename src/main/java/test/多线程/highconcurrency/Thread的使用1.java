package test.多线程.highconcurrency;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 13:35
 */
public class Thread的使用1 {
    public static void main(String[] args) {
        System.out.println(calc(10L));
    }

    public static long calc(Long count) {
        final Thread的使用1 test = new Thread的使用1();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            test.add10K(count);
        });
        Thread th2 = new Thread(() -> {
            test.add10K(count);
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test);
        return count;
    }

    private void add10K(Long count) {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
            System.out.println(count);
        }
    }
}
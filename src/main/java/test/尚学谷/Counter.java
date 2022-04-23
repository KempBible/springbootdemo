package test.尚学谷;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/23 18:57
 */
public class Counter {
    public static int count = 0;

    public static void inc() {
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }
        try {
            Thread.sleep(5000); //休眠5秒，确保线程执行完毕
        } catch (Exception e) {
        }
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:count=" + count);
    }
}
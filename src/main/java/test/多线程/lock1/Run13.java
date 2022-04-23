package test.多线程.lock1;

/**
 * @ClassName Run13
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 16:32
 */
public class Run13 {
    public static void main(String[] args) throws InterruptedException {
        Service13 service = new Service13();
        MyThread2_1 t1 = new MyThread2_1(service);
        t1.start();

        Thread.sleep(3000);
        MyThread2_2 myThread2_2 = new MyThread2_2(service);
        myThread2_2.start();
    }
}

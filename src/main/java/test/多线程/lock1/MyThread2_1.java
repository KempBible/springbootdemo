package test.多线程.lock1;

/**
 * @ClassName MyThread2_1
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/7 16:45
 */
public class MyThread2_1 extends Thread {
    private Service13 service13;

    public MyThread2_1(Service13 service13) {
        this.service13 = service13;
    }

    @Override
    public void run() {
        super.run();
        service13.methodA();
    }
}

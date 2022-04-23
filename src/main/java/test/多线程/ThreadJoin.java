package test.多线程;


import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/12 17:04
 */
//https://www.cnblogs.com/huangzejun/p/7908898.html
public class ThreadJoin {

    //父线程
    @Test
    public void Parent() {
        // 创建child对象，此时child表示的线程处于NEW状态
        Child child = new Child();
        // child表示的线程转换为RUNNABLE状态
        child.start();

        try {
            // 等待child线程运行完再继续运行
            child.join();
            System.out.println("我是线程：" + Thread.currentThread().getName() + ",我等待了3秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class Child extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
        Thread.sleep(3000);
    }
}
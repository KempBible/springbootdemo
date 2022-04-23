package test.多线程.binghe;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

//二、实现线程的方式
class ThreadTest extends Thread{
    @Override
    public void run() {
        //TODO 在此写在线程中执行的业务逻辑
    }
}

class RunnableTest implements Runnable{
    @Override
    public void run() {
        //TODO 在此写在线程中执行的业务逻辑
    }
}

class CallableTest implements Callable<String>{

    @Override
    public String call() throws Exception {
        //TODO 在此写在线程中执行的业务逻辑
        return null;
    }
}

/**
 * 线程不断休眠
 */
class WaitingTime implements Runnable{

    @Override
    public void run() {
        while (true){
            waitSecond(200);
        }
    }

    // 线程等待多少秒
    public static final void waitSecond(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 线程在Warting上等待
 */
class WaitingState implements Runnable{

    @Override
    public void run() {
        while (true){
            synchronized (WaitingState.class){
                try {
                    WaitingState.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 加锁后不再释放锁
 */
class BlockedThread implements Runnable{

    @Override
    public void run() {
        synchronized (BlockedThread.class){
            while (true){
                WaitingTime.waitSecond(100);
            }
        }
    }
}

//https://mp.weixin.qq.com/s?__biz=Mzg4MjU0OTM1OA==&mid=2247489407&idx=1&sn=fbbd0e6970064aecd0dcd603eb8489e3&chksm=cf55a07ef82229686ec55d5bbe4dabc658524e073a27fff2b1d86f0d8f56cf002b2cc0f548f5&scene=178&cur_album_id=1659019088070803460#rd
/**
 * 线程的各种状态，测试线程的生命周期
 */
public class 高并发之线程与多线程 {
    public static void main(String[] args) {
        new Thread(new WaitingTime(), "WaitingTimeThread").start();
        new Thread(new WaitingState(), "WaitingStateThread").start();

        // BlockedThread-01线程会抢到锁，BlockedThread-02线程会阻塞
        new Thread(new BlockedThread(), "BlockedThread-01").start();
        new Thread(new BlockedThread(), "BlockedThread-02").start();
    }
}

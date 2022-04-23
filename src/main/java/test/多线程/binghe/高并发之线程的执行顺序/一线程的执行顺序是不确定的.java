package test.多线程.binghe.高并发之线程的执行顺序;

//https://mp.weixin.qq.com/s?__biz=Mzg4MjU0OTM1OA==&mid=2247489406&idx=1&sn=476f4eca8e42190d837077c97e659ad3&chksm=cf55a07ff82229692bc063cff0a57036e607c496a5dd163f70e57e1348a3a9fda6c30a01e9aa&scene=178&cur_album_id=1659019088070803460#rd

/**
 * 线程的顺序，直接调用Thread.start()方法执行
 */
public class 一线程的执行顺序是不确定的 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("thread3");
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

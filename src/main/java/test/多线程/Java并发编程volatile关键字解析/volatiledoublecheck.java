package test.多线程.Java并发编程volatile关键字解析;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 19:29
 */
public class volatiledoublecheck {

}

class Singleton {
    private volatile static Singleton singleton = null;

    private Singleton() {

    }

    static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
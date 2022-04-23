package test.多线程.ThreadLocal;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/12 17:30
 */
// https://www.cnblogs.com/fsmly/p/11020641.html
public class Java中的ThreadLocal详解 {

    static ThreadLocal<String> localVar = new ThreadLocal<>();

    static void print(String str) {
        // 打印当前线程中本地内存中本地变量的值
        System.out.println(str + ":" + localVar.get());
        // 清除本地内存中的本地变量
        localVar.remove();
    }

    @Test
    public void ThreadLocal简单使用() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 设置线程1中本地变量的值
                localVar.set("localVar");
                // 调用打印方法
                print("thread1");
                // 打印本地变量
                System.out.println("after remove ：" + localVar.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 设置线程2中本地变量的值
                localVar.set("localVar2");
                // 调用打印方法
                print("thread2");
                // 打印本地变量
                System.out.println("after remove ： " + localVar.get());
            }
        });

        t1.start();
        t2.start();
    }

    /**
     * 同一个ThreadLocal变量在父线程中被设置值后，在子线程中是获取不到的。（threadLocals中为当前调用线程对应的本地变量，所以二者自然是不能共享的）
     */
    @Test
    public void ThreadLocal不支持继承性() {
        // （1）创建ThreadLocal变量
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        // 在主线程中添加主线程的本地变量
        threadLocal.set("mainVal");
        // 新创建一个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程中本地变量值：" + threadLocal.get());
            }
        });

        thread.start();

        // 输出main县城中的本地变量
        System.out.println("main线程中的本地变量值：" + threadLocal.get());

    }
}
package test.多线程.ThreadLocal;

/**
 * @Description: test
 * @author: biankunpeng
 * @date: 2021年06月30日 11:06
 */

public class ThreadLocalTest {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        THREAD_LOCAL.set("我是陈皮");
        peelChenpi();
        THREAD_LOCAL.remove();
        peelChenpi();
    }

    public static void peelChenpi() {
        System.out.println(THREAD_LOCAL.get());
    }

}

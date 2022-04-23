package test.多线程.Java并发编程volatile关键字解析;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 19:27
 */
public class volatile1状态标记量 {

    volatile boolean flag = false;

    public void test() {
        while (!flag) {
            // doSomething
        }
    }

    public void setFlag() {
        this.flag = true;
    }
}
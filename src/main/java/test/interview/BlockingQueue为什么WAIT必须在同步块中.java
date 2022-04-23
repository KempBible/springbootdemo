package test.interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/23 13:38
 */
// https://www.cnblogs.com/set-cookie/p/8686218.html
public class BlockingQueue为什么WAIT必须在同步块中 {
    Queue<String> buffer = new LinkedList<String>();

    public void give(String data) {
        buffer.add(data);
        notify();                   // Since someone may be waiting in take!
    }

    public String take() throws InterruptedException {
        while (buffer.isEmpty())    // 不能用if，因为为了防止虚假唤醒
            wait();
        return buffer.remove();
    }

}
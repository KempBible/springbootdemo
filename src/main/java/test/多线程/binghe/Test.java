package test.多线程.binghe;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.MINUTES,new SynchronousQueue<>());
    }
}

package test.多线程;

import java.util.concurrent.Callable;

/**
 * @description:实现Callable实现线程
 * @author: biankunpeng
 * @date: 2022/3/4 16:21
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        //TODO 在此写在线程中执行的业务逻辑
        return null;
    }
}
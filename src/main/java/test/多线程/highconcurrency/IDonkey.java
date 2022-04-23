package test.多线程.highconcurrency;

/**
 * @Description: IDonkey
 * @author: biankunpeng
 * @date: 2021年03月31日 19:49
 */

public interface IDonkey {

    void eat();
    default void run(){
        System.out.println("Donkey run");
    }
}

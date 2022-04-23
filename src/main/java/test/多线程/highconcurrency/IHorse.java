package test.多线程.highconcurrency;

public interface IHorse {
    void eat();

    default void run(){
        System.out.println("hurse run");
    }

    default void breath(){
        System.out.println("breath");
    }
}

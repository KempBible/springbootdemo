package test.多线程.highconcurrency;

public interface IAnimal {
    default void breath(){
        System.out.println("breath");
    }
}

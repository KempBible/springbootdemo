package test.多线程.highconcurrency;

/**
 * @Description: Mule
 * @author: biankunpeng
 * @date: 2021年03月31日 19:46
 */

public class Mule implements IHorse, IDonkey, IAnimal {


    @Override
    public void eat() {
        System.out.println("Mule eat");
    }

    @Override
    public void run() {
        IHorse.super.run();
    }

    @Override
    public void breath() {
        IAnimal.super.breath();
    }

    public static void main(String[] args) {
        Mule m = new Mule();
        m.eat();
        m.breath();
        m.run();
    }
}

package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.简单工厂模式;

public class Audi implements Car, CarFactory {

    @Override
    public void run() {
        System.out.println("奥迪");
    }

    @Override
    public Car createCar() {
        return this;
    }
}

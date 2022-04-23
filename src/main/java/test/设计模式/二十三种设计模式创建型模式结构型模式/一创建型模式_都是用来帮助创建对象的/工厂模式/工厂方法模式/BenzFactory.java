package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.工厂方法模式;

public class BenzFactory implements CarFactory, Car {
    @Override
    public Car createCar() {
        return (Car) new Audi();
    }

    @Override
    public void run() {
        System.out.println("我的奔驰");
    }
}

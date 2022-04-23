package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.工厂方法模式;

public class Client {
    public static void main(String[] args) {
        Car c1 = new AudiFactory().createCar();
        c1.run();

        Car c2 = new BenzFactory().createCar();
        c2.run();
    }
}

package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.简单工厂模式;

public class Client01 {
    public static void main(String[] args) {
        Car c1 = CarFactory01.createCar("奥迪");
        Car c2 = CarFactory01.createCar("奔驰");

        c1.run();
        c2.run();
    }
}

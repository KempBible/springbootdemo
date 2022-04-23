package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.工厂方法模式;

import test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.简单工厂模式.Car;
import test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.简单工厂模式.CarFactory;

public class Benz implements test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.简单工厂模式.Car, CarFactory {

    @Override
    public void run() {
        System.out.println("奔驰");
    }

    @Override
    public Car createCar() {
        return this;
    }
}

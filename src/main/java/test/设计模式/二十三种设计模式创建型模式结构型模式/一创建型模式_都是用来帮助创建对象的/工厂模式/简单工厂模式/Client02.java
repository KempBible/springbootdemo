package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.简单工厂模式;

public class Client02 {
     // 调用者
    public static void main(String[] args) {
        Car c1 = CarFactory02.createAudi();
        Car c2 = CarFactory02.createBenz();

        c1.run();
        c2.run();
    }
}

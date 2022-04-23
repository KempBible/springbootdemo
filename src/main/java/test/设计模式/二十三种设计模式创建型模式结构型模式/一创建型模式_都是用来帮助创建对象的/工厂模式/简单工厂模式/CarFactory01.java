package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.简单工厂模式;

// https://www.cnblogs.com/lhl0131/p/12361350.html
public class CarFactory01 {

    // 创建者
    public static Car createCar(String type){
        if ("奥迪".equals(type)){
            return new Audi();
        }else if ("奔驰".equals(type)){
            return new Benz();
        }else {
            return null;
        }
    }
}

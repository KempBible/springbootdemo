package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.三装饰模式decorator;

public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        System.out.println("添加飞行功能");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        System.out.println("添加自动驾驶功能");
        AICar aicar = new AICar(car);
        aicar.move();

    }
}

package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.建造者模式;

public class Client {
    public static void main(String[] args) {
        CarDirector director = new HgCarDirector(new HgCarBuilder());
        Car car = director.directorCar();

        System.out.println(car.getEngine().getName());

        car.run();
    }
}

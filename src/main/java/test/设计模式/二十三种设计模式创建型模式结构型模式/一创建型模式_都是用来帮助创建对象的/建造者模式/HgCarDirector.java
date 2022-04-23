package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.建造者模式;

// Hg牌汽车装配
public class HgCarDirector implements CarDirector {

    private CarBuilder builder;

    public HgCarDirector(CarBuilder builder){
        this.builder = builder;
    }

    @Override
    public Car directorCar() {
        Engine e = builder.builderEngine();
        Seat s = builder.builderSeat();
        Tyre t = builder.builderTyre();

        // 装配成汽车对象
        Car car = new Car();
        car.setEngine(e);
        car.setSeat(s);
        car.setTyre(t);

        return car;
    }
}

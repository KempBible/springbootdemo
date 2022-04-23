package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.三装饰模式decorator;

public interface  ICar {
    void move();
}

// 具体构件（真实对象）
class Car implements ICar{

    @Override
    public void move() {
        System.out.println("普通汽车");
    }
}

// 修饰角色
class  SuperCar implements ICar{

    protected ICar car;

    public SuperCar(ICar car) {
        super();
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

// 具体装饰角色
class FlyCar extends SuperCar{

    public FlyCar(ICar car) {
        super(car);
    }

    private void fly(){
        System.out.println("可以天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

// 具体装饰
class AICar extends SuperCar{

    public AICar(ICar car) {
        super(car);
    }

    private void Auto(){
        System.out.println("可以自动驾驶");
    }

    @Override
    public void move() {
        super.move();
        Auto();
    }
}

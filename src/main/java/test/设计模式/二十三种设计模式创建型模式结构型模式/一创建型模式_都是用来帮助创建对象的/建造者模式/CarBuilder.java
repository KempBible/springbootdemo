package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.建造者模式;

// 汽车构建
public interface CarBuilder {

    Engine builderEngine();
    Seat builderSeat();
    Tyre builderTyre();
}

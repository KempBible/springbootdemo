package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.抽象工厂模式;

// https://www.cnblogs.com/lhl0131/p/12361350.html
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}

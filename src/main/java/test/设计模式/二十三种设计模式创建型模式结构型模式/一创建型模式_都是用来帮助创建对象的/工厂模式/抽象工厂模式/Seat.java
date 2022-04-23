package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.抽象工厂模式;

public interface Seat {
    void message();
}

class LuxurySeat implements Seat{

    @Override
    public void message() {
        System.out.println("自动加热");
    }
}

class LowSaet implements Seat{

    @Override
    public void message() {
        System.out.println("无自动加热");
    }
}
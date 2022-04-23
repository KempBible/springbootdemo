package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.抽象工厂模式;

public interface Tyre {
    void revolve();
}

class LuxuryTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("磨损慢");
    }
}

class LowTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("磨损快");
    }
}
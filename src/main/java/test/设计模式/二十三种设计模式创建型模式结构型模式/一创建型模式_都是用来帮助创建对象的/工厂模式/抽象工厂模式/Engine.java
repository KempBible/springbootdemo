package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.工厂模式.抽象工厂模式;

public interface Engine {
    void run();
    void start();
}

class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("动力强");
    }

    @Override
    public void start() {
        System.out.println("启动快");
    }
}

class LowEngine implements Engine{

    @Override
    public void run() {
        System.out.println("动力弱");
    }

    @Override
    public void start() {
        System.out.println("启动慢");
    }
}


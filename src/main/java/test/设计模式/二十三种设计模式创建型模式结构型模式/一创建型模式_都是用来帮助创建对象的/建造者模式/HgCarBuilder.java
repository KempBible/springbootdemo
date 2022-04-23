package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.建造者模式;

// Hg牌汽车构建
public class HgCarBuilder implements CarBuilder {
    @Override
    public Engine builderEngine() {
        System.out.println("构建Hg牌发动机");
        return new Engine("Hg牌发动机");
    }

    @Override
    public Seat builderSeat() {
        System.out.println("构建座椅");
        return new Seat("Hg牌座椅");
    }

    @Override
    public Tyre builderTyre() {
        System.out.println("构建轮胎");
        return new Tyre("Hg牌轮胎");
    }
}

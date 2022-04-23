package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.建造者模式;

/**
 * Builder负责构造、Director负责装配   实现了构建和装配的解耦。
 *
 * 不同的构建器，相同的装配，可以做出不同的对象
 *
 * 相同的构建，不同的装配，也是不同的对象
 */
public class Car {

    private Engine engine; //  发动机
    private Seat seat; // 座椅
    private Tyre tyre; // 轮胎

    public void run(){
        System.out.println("汽车发动");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}

class Engine{
    private String name;

    public Engine(String name){
        super();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}

class Seat{
    public Seat(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Tyre{
    private String name;

    public Tyre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


package test.Java从入门到精通第2版.第13章;

interface A2{ // 定义一个接口
    String INFO = "Hello World.";
    void print(); // 抽象方法
}

interface B2{// 定义一个接口
    public abstract void get();
}

abstract class C2 implements A2,B2{ // 抽象类实现了A和B接口
    public abstract void fun(); // 抽象方法一共有三个
}

interface D2 extends A2,B2{ //同时继承两个接口
    public void printD();
}

class X2 extends C2 implements D2{ //先继承后实现

    @Override
    public void print() {
        System.out.println(INFO);
    }

    @Override
    public void get() {
        System.out.println("你好！");
    }

    @Override
    public void fun() {
        System.out.println("抽象类C2实现接口A2，B2");
    }

    @Override
    public void printD() {
        System.out.println("接口D2继承两个接口A2,B2");
    }
}

public class 范例13_9一个接口可继承多个接口代码AbstractInterfaces {

    public static void main(String[] args) {
        X2 x2 = new X2(); // 实例化子类对象
        A2 a2 = x2; // 为父接口实例化
        B2 b2 = x2; // 为父接口实例化
        C2 c2 = x2; // 为抽象类实例化
        D2 d2 = x2; // 父接口实现化

        a2.print();
        b2.get();
        c2.fun();
        d2.printD();
    }
}


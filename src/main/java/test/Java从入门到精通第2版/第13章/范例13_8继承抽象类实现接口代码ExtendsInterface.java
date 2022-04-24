package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c

interface A1{ //定义一个接口
    String INFO = "Hello World.";
    void print(); //抽象方法
}

interface B1{ //定义一个接口
    public abstract void get();
}

abstract class C1{ //抽象类
    public abstract void fun(); // 抽象方法
}

class X1 extends C1 implements A1,B1{ //先继承后实现

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
        System.out.println("你好！JAVA");
    }
}

public class 范例13_8继承抽象类实现接口代码ExtendsInterface {
    public static void main(String[] args) {
        X1 x1 = new X1(); //实例化子类对象
        A1 a1 = x1; // 为父接口实例化
        B1 b1 = x1; // 为父接口实例化
        C1 c1 = x1; // 为抽象类实例化
        a1.print();
        b1.get();
        c1.fun();
    }
}



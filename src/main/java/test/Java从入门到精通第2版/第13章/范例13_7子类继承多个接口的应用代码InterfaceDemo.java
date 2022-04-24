package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c

interface A{ //定义一个接口A
    public static final String INFO = "Hello World."; // 全局变量

    public abstract void print(); // 抽象方法
}

interface B{ // 定义一个接口B
    public abstract void get();
}

class X implements A,B{ // 一个子类同时实现了两个接口A、B

    @Override
    public void print() {
        System.out.println(INFO);
    }

    @Override
    public void get() {
        System.out.println("你好！");
    }
}

public class 范例13_7子类继承多个接口的应用代码InterfaceDemo {
    public static void main(String[] args) {
        X x = new X(); //实例化子类对象

        A a = x; //为父接口实例化
        B b = x; //为父接口实例化
        a.print();
        b.get();
    }
}


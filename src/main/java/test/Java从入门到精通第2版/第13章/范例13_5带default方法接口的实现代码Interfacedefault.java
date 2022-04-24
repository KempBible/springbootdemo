package test.Java从入门到精通第2版.第13章;

interface InterfaceA{ //定义一个接口
    public static String INFO = "static final."; // 全局常量

    public void print(); // 抽象方法

    default public void otherprint(){ //带方法体的默认方法
        System.out.println("print default1 methods InterfaceA!");
    }
}

class InterfaceAB implements InterfaceA{ //子类InterfaceAB

    @Override
    public void print() { // 覆写接口中的抽象方法
        System.out.println("print abstract methods InterfaceA");
        System.out.println(INFO);
    }
}

public class 范例13_5带default方法接口的实现代码Interfacedefault {
    public static void main(String[] args) {
        InterfaceAB ab = new InterfaceAB(); // 实例化子类对象
        ab.print(); //调用覆写过的抽象方法
        ab.otherprint(); // 调用接口中的默认方法

        System.out.println(InterfaceA.INFO); //输出接口中的常量
    }
}


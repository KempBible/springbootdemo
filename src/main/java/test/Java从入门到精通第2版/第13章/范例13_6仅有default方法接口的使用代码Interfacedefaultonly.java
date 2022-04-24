package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c

interface InterfaceA1 { //定义一个接口
    default public void otherprint(){ //待方法体的默认方法
        System.out.println("print default1 methods only in InterfaceA!");
    }
}

class InterfaceAB1 implements InterfaceA1{ // 子类InterfaceAB实现接口InterfaceA

}

public class 范例13_6仅有default方法接口的使用代码Interfacedefaultonly {
    public static void main(String[] args) {
        InterfaceAB1 interfaceAB1 = new InterfaceAB1(); // 实例化子类对象
        interfaceAB1.otherprint(); // 调用接口中的默认方法
    }
}



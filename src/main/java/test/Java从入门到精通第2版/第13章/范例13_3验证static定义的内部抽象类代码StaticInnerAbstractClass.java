package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c

abstract class Book{
    public abstract void print(); // 抽象方法
    static abstract class CD{ // 静态内部抽象类
        public abstract void get(); // 抽象方法
    }
}

// 继承抽象类
class JavaCD extends Book.CD{

    @Override
    public void get() {
        System.out.println("java学习");
    }
}

public class 范例13_3验证static定义的内部抽象类代码StaticInnerAbstractClass {
    public static void main(String[] args) {
        Book.CD cd = new JavaCD(); // 实例化对象
        cd.get();
    }
}


package test.Java从入门到精通第2版.第14章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck70e32fb021170efdf2eca12

class Person22{
    public Person22() {
        System.out.println("1.public Person()");
    }

    //此段代码会首先被执行
    static {
        System.out.println("2.Person类的静态代码块被调用！");
    }
}

public class 范例14_22静态代码块的使用TestStaticDemo {
    // 运行本程序时，静态代码块会被自动执行
    static {
        System.out.println("3.TestStaticDemo5类的静态代码块被调用");
    }

    public static void main(String[] args) {
        System.out.println("4.程序开始执行！");
        new Person22();
        new Person22();
    }
    /*
        3.TestStaticDemo5类的静态代码块被调用
        4.程序开始执行！
        2.Person类的静态代码块被调用！
        1.public Person()
        1.public Person()
     */
}


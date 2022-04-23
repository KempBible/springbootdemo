package test.尚学谷;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/28 17:45
 */
public class StaticTest7 {

    {
        System.out.println(456);
    }

    Book book1 = new Book("book1成员变量初始化");
    static Book book2;

    static {
        book2 = new Book("static成员book2成员变量初始化");
    }

    public StaticTest7(String msg) {
        System.out.println(msg);
    }

    Book book3 = new Book("book3成员变量初始化");
    static Book book4;

    static {
        book4 = new Book("static成员book4成员变量初始化");
    }

    public static void funStatic() {
        System.out.println("static修饰的funStatic方法");
    }

    public static void main(String[] args) {
        StaticTest7.funStatic();
        System.out.println("------------------------");
        new StaticTest7("p1初始化");
        new StaticTest7("p2初始化");
    }
}


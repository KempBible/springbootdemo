package test.尚学谷;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/28 17:45
 */
public class StaticTest5 {

    Book book1 = new Book("book1成员变量初始化");
    static Book book2 = new Book("static成员book2成员变量初始化");

    public StaticTest5(String msg) {
        System.out.println(msg);
    }

    Book book3 = new Book("book3成员变量初始化");
    static Book book4 = new Book("static成员book4成员变量初始化");

    public static void main(String[] args) {
        new StaticTest5("p1初始化");
    }
}

class Book {
    public Book(String msg) {
        System.out.println(msg);
    }
}
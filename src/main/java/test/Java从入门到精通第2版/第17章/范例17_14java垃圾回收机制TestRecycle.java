package test.Java从入门到精通第2版.第17章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck98f3284021498f137082c2e
class Book14{
    String title;
    double price;

    public void printInfo(){
        System.out.println("title:" + this.title);
        System.out.println("price:" + this.price);
    }
}

public class 范例17_14java垃圾回收机制TestRecycle {
    public static void main(String[] args) {
        Book14 bookA = new Book14(); //实例化一个对象
        Book14 bookB = new Book14();

        bookA.title = "Java程序设计"; //设置了类中的title属性
        bookA.price = 39.8; //设置price属性

        bookB.title = "Java WEB开发";
        bookB.price = 59.6;

        bookB = bookA;
        bookB.title = "Android开发";
        bookA.printInfo();
    }
}

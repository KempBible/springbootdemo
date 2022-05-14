package test.Java从入门到精通第2版.第17章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck98f3284021498f137082c2e

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Book11{
    private String title;
    private double price;

    public Book11(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book11{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
public class 范例17_12调用构造方法取得实例化对象TestInstance {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
       Class<?> cls = Class.forName("test.Java从入门到精通第2版.第17章.Book11");
       Constructor<?> cons = cls.getConstructor(String.class, double.class);
       Book11 book11 = (Book11) cons.newInstance("Java开发实战经典", 79.8);
        System.out.println(book11.toString());
    }
}


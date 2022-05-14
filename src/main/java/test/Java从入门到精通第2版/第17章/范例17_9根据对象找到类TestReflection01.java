package test.Java从入门到精通第2版.第17章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck98f3284021498f137082c2e
class Book1{
    private String title;
    private double price;

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
        return "Book1{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

public class 范例17_9根据对象找到类TestReflection01 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Book1.class;
        System.out.println(cls);
        Book1 book1 = (Book1) cls.newInstance(); //实例化一个对象
        System.out.println(book1);

        book1.setTitle("Java开发实战经典");
        book1.setPrice(79.8);
        System.out.println(book1);
    }
}


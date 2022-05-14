package test.Java从入门到精通第2版.第17章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck98f3284021498f137082c2e
class Book implements Cloneable{ //可以被克隆
    private String title;
    private double price;

    public Book(String title, double price) {
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
    protected Object clone() throws CloneNotSupportedException { //重新定义了一次clone（）
        //重新定义了一次clone();
        return super.clone();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}

public class 范例17_7实现克隆TestCloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book bookA = new Book("Java从入门到精通", 79.8);
        Book bookB = (Book)bookA.clone(); //对象克隆
        bookB.setPrice(100.8);
        System.out.println(bookA);
        System.out.println(bookB);
    }
}

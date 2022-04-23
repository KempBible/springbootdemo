package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.二桥接模式bridge;

// 电脑类型维度
public class Computer {
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void sale(){
        brand.sale();
    }
}

class Desktop extends Computer{

    public Desktop(Brand brand) {
        super(brand);
    }

    public void sale(){
        super.sale();
        System.out.println("销售台式机");
    }
}

class Laptop extends Computer{

    public Laptop(Brand brand) {
        super(brand);
    }

    public void sale(){
        super.sale();
        System.out.println("销售笔记本");
    }
}
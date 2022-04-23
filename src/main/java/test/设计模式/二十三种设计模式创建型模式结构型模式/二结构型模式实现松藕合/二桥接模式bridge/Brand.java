package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.二桥接模式bridge;

// https://www.cnblogs.com/lhl0131/p/12361350.html
// 品牌维度
public interface Brand {
    void sale();
}

class Lenovo implements Brand{

    @Override
    public void sale() {
        System.out.println("销售联想品牌");
    }
}

class Dell implements Brand{

    @Override
    public void sale() {
        System.out.println("销售戴尔品牌");
    }
}
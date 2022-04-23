package test.尚学谷.bilibili_2_对象;

class Root{
    static {
        System.out.println("Root的静态初始化块");
    }
    {
        System.out.println("Root的普通初始化块");
    }
    public Root(){
        super();
        System.out.println("Root的无参数的构造器");
    }
}

class Mid extends Root{
    static {
        System.out.println("Mid的静态初始化快");
    }
    {
        System.out.println("Mid的普通初始化块");
    }
    public Mid(){
        super();
        System.out.println("Mid的无参数的构造器");
    }
}

public class Leaf {
    public static void main(String[] args) {
        new Mid();
        System.out.println("----------------------");
        new Mid();
    }
}

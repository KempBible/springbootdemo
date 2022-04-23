package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.原型模式;

// 测试浅克隆
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep s1 = new Sheep("羊驼", 18);
        Sheep s2 = (Sheep) s1.clone();

        System.out.println(s1.getName());
        System.out.println(s1.getAge());

        System.out.println("----------------------------");
        s1.setAge(17);

        System.out.println(s1.getAge());
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
    }
}

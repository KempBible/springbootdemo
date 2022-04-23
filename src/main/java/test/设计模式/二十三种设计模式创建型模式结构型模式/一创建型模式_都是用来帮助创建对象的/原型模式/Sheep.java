package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.原型模式;

// https://www.cnblogs.com/lhl0131/p/12361350.html
public class Sheep implements Cloneable { //克隆羊，多利

    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //返回Object对象的方法
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

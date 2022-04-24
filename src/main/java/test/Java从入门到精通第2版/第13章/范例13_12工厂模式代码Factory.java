package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c

interface Fruit1{ // 定义一个水果标准
    public void eat(); //吃
}

class Apple1 implements Fruit1{

    @Override
    public void eat() {
        System.out.println("吃苹果。");
    }
}

class Orange1 implements Fruit1{

    @Override
    public void eat() {
        System.out.println("吃橘子。");
    }
}

class Factory1{ // 此类不需要维护属性的状态
    public static Fruit1 getInstance(String className){
        if ("apple".equals(className)){
            return new Apple1();
        }
        if ("orange".equals(className)){
            return new Orange1();
        }
        return null;
    }
}

public class 范例13_12工厂模式代码Factory {
    public static void main(String[] args) {
        Fruit1 fruit = Factory1.getInstance("apple");
        fruit.eat();
    }
}


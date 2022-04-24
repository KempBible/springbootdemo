package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c

interface Fruit{ // 定义一个水果标准
    public void eat(); //吃
}

class Apple implements Fruit{

    @Override
    public void eat() {
        System.out.println("吃苹果。");
    }
}

class Orange implements Fruit{

    @Override
    public void eat() {
        System.out.println("吃橘子。");
    }
}

public class 范例13_11接口的作用代码SimpleFactory {
    public static void main(String[] args) {
        Fruit fruit1 = new Apple();
        fruit1.eat();

        Fruit fruit2 = new Orange();
        fruit2.eat();
    }
}


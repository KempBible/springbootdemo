package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.二桥接模式bridge;

public class Client {
    public static void main(String[] args) {
        // 销售联想牌笔记本
        Computer computer = new Laptop(new Lenovo());
        computer.sale();
    }
}

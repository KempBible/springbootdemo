package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.一适配器模式;

// 适配器
public class Adapter extends Adaptee implements Target {
    @Override
    public void handleReq() {
        super.request();
    }
}

package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.一适配器模式;

// 客户端类、测试
public class Client {
    public void test(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        Client c = new Client();

        Target t = new Adapter();

        c.test(t);
    }
}

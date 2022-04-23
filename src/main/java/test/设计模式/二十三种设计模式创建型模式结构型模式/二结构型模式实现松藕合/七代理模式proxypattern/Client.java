package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.七代理模式proxypattern;

public class Client {
    public static void main(String[] args) {
        Star  real = new RealStar();
        Star proxy = new ProxyStar(real);

        proxy.talk();
        proxy.signContract();
        proxy.sing();
    }
}

package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.七代理模式proxypattern.动态代理;

import test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.七代理模式proxypattern.RealStar;
import test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.七代理模式proxypattern.Star;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        StarHandler handler = new StarHandler(new RealStar());

        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);

        proxy.sing();
    }
}

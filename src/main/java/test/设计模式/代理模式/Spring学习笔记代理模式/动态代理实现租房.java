package test.设计模式.代理模式.Spring学习笔记代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//https://blog.csdn.net/xu_benjamin/article/details/118415934
public class 动态代理实现租房 {
    public static void main(String[] args) {
        // 真实角色
        Host host = new Host();

        // 代理角色:现在没有
        // 实例化代理处理实例
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        // 通过代理处理的实例来设置代理对象
        proxyInvocationHandler.setRent(host);

        // 生成代理类的对象，这个对象是动态生成的
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();

        // 通过代理对象对象租房
        proxy.rent();

        /*
            中介带你看房子
            房东出租房子
            中介收中介费
         */
    }
}

interface Rent3{
    void rent();
}

class Host3 implements Rent3{

    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}

// 用这个类来自动生成代理类，这仅仅是一个处理程序
class ProxyInvocationHandler implements InvocationHandler{

    // 被代理的接口
    private Rent rent;

    void setRent(Rent rent){
        this.rent = rent;
    }

    // 生成代理类
    Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 反射机制，通过method的invoke方法实现动态代理
        seeHouse();
        Object result = method.invoke(rent, args);
        charge();
        return result;
    }

    private void seeHouse(){
        System.out.println("中介带你看房子");
    }

    private void charge(){
        System.out.println("中介收中介费");
    }
}
package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.七代理模式proxypattern.动态代理;

import test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.七代理模式proxypattern.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {

    Star realStar;

    public StarHandler(Star realStar){
        super();
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;

        if (method.getName().equals("sing")){
            object = method.invoke(realStar, args);
        }

        return object;
    }
}

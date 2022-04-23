package test.设计模式.代理模式.Java的三种代理模式Spring动态代理对象.Interface1接口采用JDK动态代理;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//https://www.cnblogs.com/qlqwjy/p/7550609.html
public class Client {

    public static void main(String[] args) throws InterruptedException {
        // jdk 代理
        Interface1 o = (Interface1) Proxy.newProxyInstance(Interface1.class.getClassLoader(), new Class[]{Interface1.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("java.lang.reflect.InvocationHandler.invoke " + method + " " + args);
                        return "123";
                    }
                }
        );

        o.method1();
        o.method2("Interface1 method2");

        //****************cglib
        //jdk需要提供接口，cglib需要是非私有类，且不能处理final关键字修改的方法
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(Cgclass1.class);
        //设置回调对象
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("方法前....." + method.getName());
                Object o1 = methodProxy.invokeSuper(o, objects);
                System.out.println("方法后....." + method.getName());
                return o1;
            }
        });

        Cgclass1 cgclass1 = (Cgclass1) enhancer.create();
        cgclass1.method1();
        cgclass1.method2("cg method2");

        Thread.sleep(50*1000);
    }
}

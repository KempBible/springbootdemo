package test.设计模式.代理模式.Java的三种代理模式Spring动态代理对象;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// https://www.cnblogs.com/qlqwjy/p/7550609.html
// 测试类:
public class 二动态代理 {
    public static void main(String[] args) {
        // 目标对象
        UserDao2 target = new UserDao2();
        // class aop.UserDao2
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao2 proxy = (IUserDao2)new ProxyFactory(target).getProxyInstance();
        // class $Proxy0 内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        System.out.println("===1===");
        proxy.save();

        System.out.println("===2===");
        proxy.delete();

        System.out.println("==========");
        proxy.saveAndDelete();

        /*
            class test.设计模式.代理模式.Java的三种代理模式Spring动态代理对象.UserDao2
            class test.设计模式.代理模式.Java的三种代理模式Spring动态代理对象.$Proxy0
            ===1===
            开始事物2
            save
            提交事物2
            ===2===
            开始事物2
            delete
            提交事物2
            ==========
            开始事物2
            save
            delete
            提交事物2
         */
    }
}

/**
 * 接口和默认实现：
 */
interface IUserDao2{
    void save();

    void delete();

    void saveAndDelete();
}

/**
 * 实现类：
 */
class UserDao2 implements IUserDao2{

    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void saveAndDelete() {
        save();
        delete();
    }
}

/**
 * 代理工厂类:ProxyFactory.java
 */

/**
 * 创建动态代理对象
 * 动态代理不需要实现接口，但是需要指定接口类型
 */
class ProxyFactory{

    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事物2");
                        // 运用反射执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事物2");
                        return returnValue;
                    }
                }
        );
    }
}
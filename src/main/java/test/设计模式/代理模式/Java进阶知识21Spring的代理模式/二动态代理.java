package test.设计模式.代理模式.Java进阶知识21Spring的代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// https://www.cnblogs.com/dshore123/p/11753623.html
/**
 * 1、代理对象，不需要实现接口；
 * 2、代理对象的生成，是利用JDKAPI，动态的在内存中构建代理对象（需要我们指定创建代理对象/目标对象、实现的接口的类型）；
 * 3、动态代理，JDK代理，接口代理；
 */
public class 二动态代理 {
    public static void main(String[] args) {
        // 目标
        IUserDao2 target = new UserDao2();
        // 代理
        IUserDao2 userDao2Proxy = (IUserDao2) new ProxyFactory(target).getProxyInstance();
        //System.out.println(userDaoProxy.getClass()); // 返回值：class $Proxy4  （com.sun.proxy.$Proxy4）
        userDao2Proxy.save();
    }
}

interface IUserDao2{ // 接口
    public void save();
}

//------------------------------------------
//实现类
class UserDao2 implements IUserDao2{

    @Override
    public void save() {
        // System.out.println("开启事务======="); //动态代理，这一步交给代理工厂做了
        System.out.println("保存用户成功！"); // 相当于session.save(obj); //持久化操作
        // System.out.println("提交事务======="); //动态代理，这一步也是交给代理工厂做了
    }
}

// 动态代理工厂类 （不需要 实现接口）
class ProxyFactory{

    // 维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        super();
        this.target = target;
    }

    // 创建代理
    public Object getProxyInstance() throws IllegalArgumentException{
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), // 定义代理类的类加载器
                target.getClass().getInterfaces(), // 代理类要实现的接口列表（获取所有接口）
                new InvocationHandler() {
                    // 指派方法调用的调用处理程序
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开启事务=======");

                        Object returnValue = method.invoke(target, args); // 放行

                        System.out.println("提交事务=======");
                        return returnValue;
                    }
                });
    }

    public Object getTarget(){
        return target;
    }

    public void setTarget(Object target){
        this.target = target;
    }
}
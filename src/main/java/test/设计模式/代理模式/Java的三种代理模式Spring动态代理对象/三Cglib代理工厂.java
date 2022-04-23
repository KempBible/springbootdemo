package test.设计模式.代理模式.Java的三种代理模式Spring动态代理对象;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// https://www.cnblogs.com/qlqwjy/p/7550609.html
public class 三Cglib代理工厂 {
    public static void main(String[] args) {
        // 在指定目录下生产动态代理类，我们可以反编译看一下里面到底是一些什么东西
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
                "/Users/kemp/IdeaProjects/springbootdemo/src/main/java/test/设计模式/代理模式/Java的三种代理模式Spring动态代理对象");

        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory();
        // jdk需要提供接口，cglib需要是非私有类，且不能处理final关键字修饰的方法
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(UserDao3.class);
        // 设置回调对象
        enhancer.setCallback(cglibProxyFactory);

        UserDao3 proxy = (UserDao3)enhancer.create();

        System.out.println("===1===");
        proxy.save();

        System.out.println("===2===");
        proxy.delete();

        System.out.println("=========");
        proxy.saveAndDelete();
    }
}

/**
 * 实现类：
 */
class UserDao3{

    public void save() {
        System.out.println("save");
    }

    public void delete() {
        System.out.println("delete");
    }

    public void saveAndDelete() {
        save();
        delete();
    }
}

class CglibProxyFactory implements MethodInterceptor{

    public CglibProxyFactory() {
    }

    /**
     * 1.代理对象；2.委托类对象；3.方法参数；4.代理方法的MethodProxy对象
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事物开始......" + method.getName());
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("事物结束......" + method.getName());
        return o1;
    }
}
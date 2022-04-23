package test.设计模式.代理模式.Java进阶知识21Spring的代理模式;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// https://www.cnblogs.com/dshore123/p/11753623.html
/**
 * 2.3.1、Cglib代理，也叫做子类代理。在内存中构建一个子类对象从而实现对目标对象功能的扩展。
 * 1、JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。如果想代理没有实现接口的类，就可以使用CGLIB实现。
 * 2、CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。
 * 3、CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。
 */
public class 三Cglib子类代理 {
    @Test
    public void testCglibProxy(){
        // 目标
        UserDao3 tartget = new UserDao3();
        // 代理
        UserDao3 userDao3Proxy = (UserDao3) new ProxyFactory3(tartget).getProxyInstance();

        /**
         * JAVA定义class，英文字符中仅支持 $ 和 _
         */
        //System.out.println(userDaoProxy.getClass()); //返回值：class com.shore.dao.UserDao$$EnhancerByCGLIB$$1543b6de
        userDao3Proxy.save();
    }
}

class UserDao3{
    public void save(){
        // System.out.println("开启事务......"); //这一步，交给代理来做
        System.out.println("保存用户成功！"); // session.save(obj);
        // System.out.println("提交事务......"); //这一步，交给代理来做
        /*
            开启事务-------
            保存用户成功！
            提交事务-------
         */
    }
}

// 代理工厂类
class ProxyFactory3 implements MethodInterceptor {

    // 维护一个目标对象
    private Object target;

    public ProxyFactory3(Object target) {
        super();
        this.target = target;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance(){
        // 1.调用工具类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(target.getClass());
        // 3.设置回调函数，执行target方法的时候，触发拦截器intercept方法
        enhancer.setCallback((Callback) this);
        return enhancer.create();
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务-------");

        Object returnValue = method.invoke(target, objects);

        System.out.println("提交事务-------");
        return returnValue;
    }
}
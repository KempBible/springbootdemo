package test.设计模式.代理模式.Spring学习笔记代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//https://blog.csdn.net/xu_benjamin/article/details/118415934
// 1.编写生成代理类的处理程序
// 用这个类来自动生成代理类，这仅仅是一个处理程序
class ProxyInvocationHandler4 implements InvocationHandler{

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 反射机制，通过method的invoke方法实现动态处理
        log(method.getName());
        Object result = method.invoke(target, args);
        return result;
    }

    // 新增日志方法
    private void log(String msg){
        System.out.println("[Debug] 调用了"+msg+"方法");
    }
}

// 2.客户端：真实角色=>实例化生成代理类的程序=>设置要代理的对象=>动态生成代理类，得到代理角色=>通过代理角色调用真实角色的方法
public class 动态代理实现用户业务代理 {

    public static void main(String[] args) {
        // 真实角色
        UserServiceImpl userService = new UserServiceImpl();
        // 代理角色，不存在
        ProxyInvocationHandler4 proxyInvocationHandler4 = new ProxyInvocationHandler4();
        // 设置要代理的对象
        proxyInvocationHandler4.setTarget(userService);
        // 动态生成代理类
        UserService userServiceProxy = (UserService) proxyInvocationHandler4.getProxy();
        userServiceProxy.delete();
        /*
            [Debug] 调用了delete方法
            删除一个用户
         */
    }
}
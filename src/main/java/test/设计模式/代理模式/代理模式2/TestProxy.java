package test.设计模式.代理模式.代理模式2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        UserServiceImpl serviceImpl = new UserServiceImpl();
        UserService service = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (Object.class.equals(method.getDeclaringClass())) {
                    return method.invoke(this, args);
                }
                System.out.println("织入预处理逻辑到" + method.getName() + "方法");
                Object object = method.invoke(serviceImpl, args);
                System.out.println("织入后处理逻辑到" + method.getName() + "方法");
                return object;
            }
        });
        service.save();
    }
}

package test.设计模式.代理模式.Java进阶知识21Spring的代理模式;

import org.junit.jupiter.api.Test;

// https://www.cnblogs.com/dshore123/p/11753623.html
public class 一静态代理 {

    @Test
    public void testStaticProxy(){
        // 目标
        IUserDao target = new UserDao();
        // 代理
        IUserDao userDaoProxy = new UserDaoProxy(target);
        userDaoProxy.save();
    }
}
interface IUserDao{
    public void save();
}

//---------------------------------

class UserDao implements IUserDao{ // 实现类

    @Override
    public void save() {
        // System.out.println("开启事务......"); //这一步，交给代理来做
        System.out.println("保护用户成功");
        // System.out.println("提交事务......"); //这一步，交给代理来做
    }
}

class UserDaoProxy implements IUserDao{

    // 目标对象
    IUserDao target = new UserDao();

    public UserDaoProxy(IUserDao target) {
        super();
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开启事务......");
        target.save();
        System.out.println("提交事务......");
    }
}
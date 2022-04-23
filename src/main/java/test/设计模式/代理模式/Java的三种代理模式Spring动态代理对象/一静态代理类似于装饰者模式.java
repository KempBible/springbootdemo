package test.设计模式.代理模式.Java的三种代理模式Spring动态代理对象;

//https://www.cnblogs.com/qlqwjy/p/7550609.html
// 测试类:App.java
public class 一静态代理类似于装饰者模式 {
    public static void main(String[] args) {
        // 目标对象
        UserDao1 target = new UserDao1();

        // 代理对象，把目标对象传给代理对象，建立代理关系
        UserDaoProxy1 proxy1 = new UserDaoProxy1(target);
        proxy1.save();
        /*
            开始事务...
            ----已经保存数据!----
            提交事务...
         */
    }
}

// 接口:IUserDao.java
/**
 * 接口
 */
interface IUserDao1{
    void save();
}

// 目标对象:UserDao.java
/**
 * 接口实现
 * 目标对象
 */
class UserDao1 implements IUserDao1{

    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}

// 代理对象:UserDaoProxy.java
/**
 * 代理对象，静态代理
 */
class UserDaoProxy1 implements IUserDao1{
    // 接收保存目标对象
    private IUserDao1 target;

    public UserDaoProxy1(IUserDao1 target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务...");
        target.save(); // 执行目标对象的方法
        System.out.println("提交事务...");
    }
}
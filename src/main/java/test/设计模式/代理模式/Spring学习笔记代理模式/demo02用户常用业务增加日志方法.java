package test.设计模式.代理模式.Spring学习笔记代理模式;

// https://blog.csdn.net/xu_benjamin/article/details/118415934
public class demo02用户常用业务增加日志方法 {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        // 使用代理对象来做一些操作
        UserServiceProxyImpl userServiceProxy = new UserServiceProxyImpl();
        userServiceProxy.setUserService(userService);
        userServiceProxy.update();
    }
}

// 1.抽象对象：用户业务
// 抽象对象
interface UserService{
    void add();
    void delete();
    void update();
    void query();
}

// 2.真实对象：业务实现类
// 真实对象
class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("增加一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除一个用户");
    }

    @Override
    public void update() {
        System.out.println("修改一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询一个用户");
    }
}

// 3.代理对象：代理类
class UserServiceProxyImpl implements UserService{

    private UserServiceImpl userService;

    void setUserService(UserServiceImpl userService){
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    // 在代理对象中添加日志方法
    private void log(String msg){
        System.out.println("[Debug] 调用了"+msg+"方法");
    }
}
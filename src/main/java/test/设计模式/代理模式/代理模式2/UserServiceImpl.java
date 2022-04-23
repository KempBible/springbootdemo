package test.设计模式.代理模式.代理模式2;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("执行业务操作Save");
    }
}

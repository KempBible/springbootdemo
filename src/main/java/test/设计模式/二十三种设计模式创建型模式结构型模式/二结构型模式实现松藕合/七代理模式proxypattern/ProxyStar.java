package test.设计模式.二十三种设计模式创建型模式结构型模式.二结构型模式实现松藕合.七代理模式proxypattern;

// 代理
public class ProxyStar implements Star {
    private Star star;

    public ProxyStar(Star star) {
        super();
        this.star = star;
    }

    @Override
    public void talk() {
        System.out.println("聊天");
    }

    @Override
    public void signContract() {
        System.out.println("签合同");
    }

    @Override
    public void sing() {
        star.sing();
    }
}

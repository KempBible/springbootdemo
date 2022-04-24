package test.Java从入门到精通第2版.第13章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckc7432af0210c74d97b01b1c

abstract class Subject{ //代理请求
    abstract public void request();
}

class RealSuject extends Subject{ //真实角色（红酒厂商）

    @Override
    public void request() { // 覆写抽象方法
        System.out.println("我是红酒厂商，欢迎品尝购买");
    }
}

class ProxySubject extends Subject{ //代理角色（代理商）

    private RealSuject realSuject; //以真实角色作为代理角色的属性

    @Override
    public void request() { // 该方法封装了真实对象的request方法
        preRequest();
        if (realSuject == null){
            realSuject = new RealSuject();
        }
        realSuject.request(); //此处执行真实对象的request方法
        postRequest();
    }

    private void postRequest() {
        System.out.println("付款购买");
    }

    private void preRequest() {
        System.out.println("广告宣传，免费品尝");
    }
}

public class 范例13_13代理设计模式代码Proxytest { // 客户直接找代理商
    public static void main(String[] args) {
        Subject sub = new ProxySubject(); // 子类为接口实例化
        sub.request();
    }
}

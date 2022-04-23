package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例;

interface Info {
    void setVar(String var);
    String getVar();
}


// 定义泛型接口的子类
class InfoImpl implements Info {
    private String var; // 定义属性

    // 通过构造方法设置属性内容
    public InfoImpl(String var) {
        this.var = var;
    }

    @Override
    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public String getVar() {
        return this.var;
    }
}

public class 泛型接口定义及使用_使用方法一非泛型类{
    public static void main(String[] args) {
        InfoImpl i = new InfoImpl("harvic");
        System.out.println(i.getVar());
    }
}
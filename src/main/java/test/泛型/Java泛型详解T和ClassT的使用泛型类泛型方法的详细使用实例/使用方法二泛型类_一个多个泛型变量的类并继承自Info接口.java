package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例;

// 在接口上定义泛型
interface info1<T>{
    public T getVar(); // 定义抽象方法，抽象方法的返回值就是泛型类型
    public void setVar(T var);
}

// 定义泛型接口的子类
class InfoImpl_Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例<T,K,U> implements info1<U>{

    private U var;
    private T x;
    private K y;
    // 通过构造方法设置属性内容
    public InfoImpl_Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例(U var){
        this.setVar(var);
    }

    @Override
    public U getVar() {
        return this.var;
    }

    @Override
    public void setVar(U var) {
        this.var = var;
    }
}

public class 使用方法二泛型类_一个多个泛型变量的类并继承自Info接口 {
    public static void main(String[] args) {
        InfoImpl_Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例<Integer, Double, String> i
                = new InfoImpl_Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例<>("rocling");
        System.out.println(i.getVar());
    }
}

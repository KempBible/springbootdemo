package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例;

// 在接口上定义泛型
interface info<T>{
    public T getVar(); // 定义抽象方法，抽象方法的返回值就是泛型类型
    public void setVar(T var);
}

// 定义泛型接口的子类
class infoImpl<T> implements info<T>{
    private T var; // 定义属性

    // 通过构造方法设置属性内容
    public infoImpl(T var) {
        this.var = var;
    }

    @Override
    public T getVar() {
        return this.var;
    }

    @Override
    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return "infoImpl{" +
                "var=" + var +
                '}';
    }
}

public class 使用方法二泛型类 {
    public static void main(String[] args) {
        infoImpl<String> info = new infoImpl<String>("kemp");
        System.out.println(info.getVar());
    }
}

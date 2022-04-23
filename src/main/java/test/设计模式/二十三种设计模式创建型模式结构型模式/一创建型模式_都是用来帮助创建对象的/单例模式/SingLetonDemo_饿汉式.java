package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.单例模式;

// 1.饿汉式（线程安全，调用效率高，不能延时加载）
public class SingLetonDemo_饿汉式 {

    // 类初始化时，立即加载这个对象。加载类时，天然的线程安全
    private static SingLetonDemo_饿汉式 sld = new SingLetonDemo_饿汉式();
    // 构造器私有化
    private SingLetonDemo_饿汉式(){

    }

    // 方式没有同步，调用效率高
    public static SingLetonDemo_饿汉式 getSld(){
        return sld;
    }
}


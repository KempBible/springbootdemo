package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.单例模式;

// 4.静态内部类式（线程安全，调用效率高，可以延时加载，并发效率高）
public class SingLetonDemo_静态内部类式 {

    private static class SingLetonClassInstance{
        private static final SingLetonDemo_静态内部类式 sld = new SingLetonDemo_静态内部类式();
    }

    // 私有构造器
    private SingLetonDemo_静态内部类式(){

    }

    // 方法没有同步
    public static SingLetonDemo_静态内部类式 getSld(){
        return SingLetonClassInstance.sld;
    }
}

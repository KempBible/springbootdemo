package test.设计模式.二十三种设计模式创建型模式结构型模式.一创建型模式_都是用来帮助创建对象的.单例模式;

// 2.懒汉式（线程安全，调用效率不高，可以延时加载，并发效率低）
public class SingLetonDemo_懒汉式 {

    // 不初始化，临时加载，使用时再加载
    private static SingLetonDemo_懒汉式 lsd;

    // 构造器私有化
    private SingLetonDemo_懒汉式(){

    }

    // 方法必须加入同步（有同步，效率低）
    public static synchronized SingLetonDemo_懒汉式 getLsd(){
        if (lsd == null){
            lsd = new SingLetonDemo_懒汉式();
        }
        return lsd;
    }
}

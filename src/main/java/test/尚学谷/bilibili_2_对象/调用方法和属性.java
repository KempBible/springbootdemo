package test.尚学谷.bilibili_2_对象;

/**
 * 练习
 * 1.若子类重写了父类方法，就意味着子类里定义的方法覆盖了父类里的同名方法
 * 系统将不可能把父类里的方法转移到子类中，编译看左边，运行看右边
 *
 * 2.对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量
 * 这个实例变量依然不可能覆盖父类中定义的实例变量，编译运行都看左边
 */
class Base{
    int count = 10;

    public void display(){
        System.out.println(this.count);
    }
}

class Sub extends Base{
    int count = 20;

    public void display(){
        System.out.println(this.count);
    }
}

public class 调用方法和属性 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.count); // 20
        sub.display();

        // ==,对于引用数据类型来讲，比较的是两个引用数据类型变量的地址是否相同
        Base base = sub;
        System.out.println(sub == base); // true
        System.out.println(base.count); // 10
        base.display(); //20
    }
}

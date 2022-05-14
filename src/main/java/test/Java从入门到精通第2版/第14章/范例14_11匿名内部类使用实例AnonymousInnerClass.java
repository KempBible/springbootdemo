package test.Java从入门到精通第2版.第14章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck70e32fb021170efdf2eca12

abstract class Bird{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}

public class 范例14_11匿名内部类使用实例AnonymousInnerClass {

    public void test(Bird bird){
        System.out.println(bird.getName() + "最高能飞" + bird.fly() + "米");
    }

    public static void main(String[] args) {
        范例14_11匿名内部类使用实例AnonymousInnerClass test = new 范例14_11匿名内部类使用实例AnonymousInnerClass();
        test.test(new Bird() {
            @Override
            public int fly() {
                return 100;
            }

            @Override
            public String getName() {
                return "小鸟";
            }
        });

        System.out.println(args.length);
    }
}




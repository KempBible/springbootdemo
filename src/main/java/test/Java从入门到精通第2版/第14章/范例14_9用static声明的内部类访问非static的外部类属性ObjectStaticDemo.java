package test.Java从入门到精通第2版.第14章;

// https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck70e32fb021170efdf2eca12

class StaticInnerClassTest{
    private int prop1 = 5;
    private static int prop2 = 9;

    void display(){
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.display();
    }

    static class StaticInnerClass {
        // 静态内部类里可以包含静态成员
        private static int age;

        public void display(){
            //下面代码出现错误
            //静态内部类无法访问外部类的实例成员
            //System.out.println(prop1);
            //下面代码正常
            System.out.println(prop2);
        }
    }
}

public class 范例14_9用static声明的内部类访问非static的外部类属性ObjectStaticDemo {
    public static void main(String[] args) {
        StaticInnerClassTest staticInnerClassTest = new StaticInnerClassTest();
        staticInnerClassTest.display();
    }
}

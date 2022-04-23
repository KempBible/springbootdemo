package test.尚学谷.bilibili_2_对象;

public class SubClassTest {

    public static void main(String[] args) {
        SubClass s = new SubClass();

//        s.method1();
//        SubClass.method1();
        // 知识点1：接口中定义的静态方法，只能通过接口来调用。
        CompareA.method1(); // CompareA:北京
        // 知识点2：通过实现类的对象，可以调用接口中的默认方法
        // 如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
        s.method2(); // SubClass:上海
        // 知识点3：如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法
        // 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法
        // 知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法
        // 那么在实现类没有重写此方法的情况下，报错。 -->接口冲突
        // 这就需要我们必须在实现类中重写此方法
        s.method3(); // SubClass:深圳

//        SubClass.method2();
    }
}

class SubClass extends SuperClass implements CompareA, CompareB{
// class SubClass implements CompareA, CompareB{
    @Override
    public void method2() {
        System.out.println("SubClass:上海");
    }

    @Override
    public void method3() {
        System.out.println("SubClass:深圳");
    }

    // 知识点5：如何在子类（或实现类）的方法中调用父类、接口中被重写的方法
    public void myMethod(){
        method3(); // 自己定义的重写方法
        super.method3(); // 调用的是父类中声明的
        // 调用接口中的默认方法
        CompareA.super.method3();
        CompareB.super.method3();
    }
}

class SuperClass{

    public void method3(){
        System.out.println("SuperClass:北京");
    }
}

/**
 * JDK8:除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 */
interface CompareA{

    // 静态方法
    public static void method1(){
        System.out.println("CompareA:北京");
    }

    // 默认方法
    public default void method2(){
        System.out.println("CompareA:上海");
    }

    default void method3(){
        System.out.println("CompareA:上海");
    }
}

interface CompareB{

    default void method3(){
        System.out.println("CompareB:上海");
    }
}
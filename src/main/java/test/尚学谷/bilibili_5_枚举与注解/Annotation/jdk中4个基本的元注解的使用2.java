package test.尚学谷.bilibili_5_枚举与注解.Annotation;

import java.util.ArrayList;
import java.util.Date;

/**
 * 注解的作用
 *
 * 1.理解Annotation：
 * a.jdk 5.0 新增的功能
 * b.Annotation其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理。通过使用
 *  程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息
 * c.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android
 *  中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等
 *  代码和XML配置等
 *
 *  2.Annotation的使用示例
 *  示例一：生成文档相关的注解
 *  示例二：在编译时进行格式检查（JDK内置的三个基本注解）
 *  @Override：限制重写父类方法，该注解只能用于方法
 *  @Deprecated：用于表示所修饰的元素（类，方法等）已过时。通常是因为所修饰的结构危险或存在更好的选择
 *  @SuppressWarnings：抑制编译器警告
 *
 *  示例三：跟踪代码依赖性，实现替代配置文件功能
 *  3.如何自定义注解：参照@SuppressWarning定义
 *      a.注解声明为：@interface
 *      b.内部定义成员，通常使用value表示
 *      c.可以指定成员的默认值，使用default定义
 *      d.如果自定义注解没有成员，表明是一个标识作用
 *
 *     如果注解有成员，在使用注解时，需要指明成员的值
 *     自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 *     自定义注解通过都会指明两个元注解：Retention、Target
 *
 *   4.jdk 提供的4种元注解
 *      元注解：对现有的注解进行解释说明的注解
 *      Retention：指定所修饰的Annotation的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
 *                 只有声明为RUNTIME生命周期的注解，才能通过反射获取
 *      Target：用于指定被修饰的Annotation能用于修饰哪些程序元素
 *      *****出现的频率*****
 *      Documented：表示所修饰的注解在被javadoc解析时，保留下来
 *      Inherited：被它修饰的Annotation将具有继承性
 *
 *    5.通过反射获取
 */
public class jdk中4个基本的元注解的使用2 {
    public static void main(String[] args) {
        Person1 person1 = new Student1();
        // person.walk(); // 不带@override 人走路
        person1.walk(); // 学生走路

        Date date = new Date(2022,4,10);
        System.out.println(date); // Wed May 10 00:00:00 CST 3922

        @SuppressWarnings("unused")
        int num = 10;
        // System.out.println(num);

        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList list = new ArrayList();
    }
}

// @MyAnnotation1没有类的元注解
class Person1{
    private String name;
    private int age;

    public Person1() {
    }

    @MyAnnotation1
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation1
    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info2{
    void show();
}

class Student1 extends Person1 implements Info2{

//    public void walk() {
//        System.out.println("学生走路");
//    }

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {
        System.out.println();
    }
}
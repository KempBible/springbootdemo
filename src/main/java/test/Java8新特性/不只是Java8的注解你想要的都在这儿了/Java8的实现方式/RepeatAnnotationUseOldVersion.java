package test.Java8新特性.不只是Java8的注解你想要的都在这儿了.Java8的实现方式;

public class RepeatAnnotationUseOldVersion {

    @MyAnnotation(role="Admin")
    @MyAnnotation(role="Manager")
    public static void doSomething(){
        System.out.println(123);
    }

    public static void main(String[] args) {
        doSomething();
    }
}

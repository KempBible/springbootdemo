package test.Java8新特性.不只是Java8的注解你想要的都在这儿了.Java8以前的注解方式;

public class RepeatAnnotationUseOldVersion {
    @Annotations({@MyAnnotation(role="Admin"),@MyAnnotation(role="Manager")})
    public void doSomething(){

    }
}

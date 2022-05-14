package test.Java8新特性.不只是Java8的注解你想要的都在这儿了.Java8的实现方式;

import java.lang.annotation.Repeatable;

@Repeatable(Annotations.class)
public @interface MyAnnotation {
    String role();
}

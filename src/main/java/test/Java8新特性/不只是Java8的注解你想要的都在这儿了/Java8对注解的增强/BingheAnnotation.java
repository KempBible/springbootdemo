package test.Java8新特性.不只是Java8的注解你想要的都在这儿了.Java8对注解的增强;


import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Repeatable(BingheAnnotations.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE,ElementType.TYPE_PARAMETER})
public @interface BingheAnnotation {

    String value();
}

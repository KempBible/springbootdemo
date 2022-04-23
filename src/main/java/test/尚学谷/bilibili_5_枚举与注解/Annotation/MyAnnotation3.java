package test.尚学谷.bilibili_5_枚举与注解.Annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotation3 {

    String value() default "hello";
}
package test.尚学谷.bilibili_5_枚举与注解.Annotation;

//public @interface MyAnnotation {
//
//    String value();
//}

//public @interface MyAnnotation {
//
//    String value() default "hello";
//}

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
package test.Java8新特性.不只是Java8的注解你想要的都在这儿了.Java8对注解的增强;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BingheAnnotationTest {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Binghe> clazz = Binghe.class;
        BingheAnnotation[] annotations = clazz.getAnnotationsByType(BingheAnnotation.class);
        System.out.println("类上的重复注如下：");
        Arrays.stream(annotations).forEach(a -> System.out.println(a.value()));

        System.out.println();
        System.out.println("=============");

        Method method = clazz.getMethod("init");
        annotations = method.getAnnotationsByType(BingheAnnotation.class);
        System.out.println("方法上的重复注解下：");
        Arrays.stream(annotations).forEach(a -> System.out.println(a.value()));

    }

}

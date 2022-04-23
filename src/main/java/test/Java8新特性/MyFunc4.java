package test.Java8新特性;

@FunctionalInterface
public interface MyFunc4<T, R> {
    R getValue(T t1, T t2);
}

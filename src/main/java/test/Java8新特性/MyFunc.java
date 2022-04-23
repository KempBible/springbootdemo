package test.Java8新特性;

@FunctionalInterface
public interface MyFunc<T> {
    T getValue(T t);
}

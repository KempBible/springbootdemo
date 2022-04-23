package test.Java8新特性;

//设计模式策略模式
public interface MyPredicate<T> {
    /**
     * 对传递过来的T类型的数据进行过滤
     * 符合规则返回true，不符合规则返回false
     */
    boolean filter(T t);
}

package test.Java8新特性.接口中的默认方法和静态方法你都掌握了吗.接口冲突如果一个父接口提供一个默认方法而另一个接口也提供了一个具有相同名称和参数列表的方法不管方法是否是默认方法那么必须覆盖该方法来解决冲突;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 17:55
 */
public interface MyInterface {
    default String getName() {
        return "interface";
    }
}
package test.Java8新特性.接口中的默认方法和静态方法你都掌握了吗.选择父类中的方法如果一个父类提供了具体的实现那么接口中具有相同名称和参数的默认方法会被忽略;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 17:49
 */
public interface MyFunction {

    default String getName() {
        return "MyFunction";
    }
}
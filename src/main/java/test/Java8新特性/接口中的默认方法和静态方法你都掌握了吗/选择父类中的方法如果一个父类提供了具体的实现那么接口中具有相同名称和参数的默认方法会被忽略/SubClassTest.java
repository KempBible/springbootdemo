package test.Java8新特性.接口中的默认方法和静态方法你都掌握了吗.选择父类中的方法如果一个父类提供了具体的实现那么接口中具有相同名称和参数的默认方法会被忽略;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 17:51
 */
public class SubClassTest {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());
    }
}
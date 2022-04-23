package test.尚学谷;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/28 17:45
 */
public class StaticTest1 {

    String name;
    int age;

    @Override
    public String toString() {
        return "StaticTest1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        StaticTest1 staticTest1 = new StaticTest1();
        staticTest1.name = "zhangsan";
        staticTest1.age = 10;
        StaticTest1 staticTest12 = new StaticTest1();
        staticTest12.name = "lisi";
        staticTest12.age = 12;
        System.out.println(staticTest1);
        System.out.println(staticTest12);
    }

}
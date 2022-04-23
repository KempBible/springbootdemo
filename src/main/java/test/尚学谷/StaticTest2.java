package test.尚学谷;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/28 17:45
 */
public class StaticTest2 {

    String name;
    static int age = 10;

    @Override
    public String toString() {
        return "StaticTest1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        StaticTest2 staticTest1 = new StaticTest2();
        staticTest1.name = "zhangsan";
        staticTest1.age = 12;
        StaticTest2 staticTest12 = new StaticTest2();
        staticTest12.name = "lisi";
//        staticTest12.age = 12;
        System.out.println(staticTest12);
        System.out.println(staticTest12);
    }

}
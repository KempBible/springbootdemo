package test.尚学谷;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/28 17:45
 */
public class StaticTest3 {
    private static int count = 0;

    int id;
    String name;
    int age;

    StaticTest3() {
        id = ++count;
    }

    @Override
    public String toString() {
        return "StaticTest3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        StaticTest3 staticTest1 = new StaticTest3();
        staticTest1.name = "zhangsan";
        staticTest1.age = 10;

        StaticTest3 staticTest12 = new StaticTest3();
        staticTest12.name = "lisi";
        staticTest12.age = 12;
        System.out.println(staticTest1);
        System.out.println(staticTest12);
    }

}
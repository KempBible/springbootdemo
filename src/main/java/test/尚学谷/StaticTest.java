package test.尚学谷;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/28 17:39
 */
// https://www.cnblogs.com/dotgua/p/6354151.html
public class StaticTest {

    public static void main(String[] args) {
        Person p2 = new Person();
        p2.id = 1;
        p2.name = "李四";
        p2.age = 12;
        System.out.println(p2);

        Person p1 = new Person();
        p1.id = 1;
        p1.name = "张三";
        System.out.println(p1);
    }
}

class Person {

    int id;
    String name;

    static int age = 10;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
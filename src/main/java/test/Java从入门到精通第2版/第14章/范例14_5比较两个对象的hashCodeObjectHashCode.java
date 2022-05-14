package test.Java从入门到精通第2版.第14章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck70e32fb021170efdf2eca12
class Person5{
    int id; // 编号
    String name; // 姓名

    public Person5(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        Person5 person5 = (Person5) o;

        if (id != person5.id) return false;
        return name.equals(person5.name);
    }

    @Override
    public int hashCode() {
        return id * name.hashCode();
    }
}

public class 范例14_5比较两个对象的hashCodeObjectHashCode {
    public static void main(String[] args) {
        Person5 person5_1 = new Person5(1,"小刚");
        Person5 person5_2 = new Person5(1,"小刚");
        Person5 person5_3 = new Person5(2,"小刚");

        System.out.println(person5_1.equals(person5_2)); // 输出p1与p2比较的结果
        System.out.println(person5_1.equals(person5_3)); // 输出p1与p3比较的结果
        System.out.println(person5_1.hashCode()); //输出p1的hashCode
        System.out.println(person5_2.hashCode()); //输出p2的hashCode
        System.out.println(person5_3.hashCode()); //输出p3的hashCode
    }
}


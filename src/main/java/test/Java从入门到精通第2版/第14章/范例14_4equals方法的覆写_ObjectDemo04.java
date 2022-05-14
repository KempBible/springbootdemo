package test.Java从入门到精通第2版.第14章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck70e32fb021170efdf2eca12
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 覆写父类（Object类）中的equals方法
    public boolean equals(Object o){
        boolean temp = true;
        // 声明一p1对象，此对象实际上就是当前调用equals方法的对象
        Person p1 = this;
        //判断Object类对象是否是Person的实例
        if (o instanceof Person){
            // 如果是Person类实例，则进行向下转型
            Person p2 = (Person) o;
            // 调用String类中的equals方法
            if (p1.name.equals(p2.name) && p1.age == p2.age){
                temp = true;
            }else {
                // 如果不是Person类实例，则直接返回false
                temp = false;
            }
        }
        return temp;
    }
}

public class 范例14_4equals方法的覆写_ObjectDemo04 {
    public static void main(String[] args) {
        Person person1 = new Person("张三", 25);
        Person person2 = new Person("张三", 25);
        //判断p1和p2的内容是否相等
        System.out.println(person1.equals(person2) ? "是同一个人！":"不是同一个人");
    }
}


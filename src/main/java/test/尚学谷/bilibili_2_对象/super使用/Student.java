package test.尚学谷.bilibili_2_对象.super使用;

public class Student extends Person {

    String name;
    String major;
    int id = 1002;

    public Student() {
    }

    public Student(String major) {
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void eat() {
        System.out.println("学生，多吃有营养的食物");
    }

    @Override
    public void study() {
        System.out.println("学生，学习知识");
        this.eat();
    }

    public void show(){
        System.out.println("Student{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", id=" + id +
                '}');
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", id=" + id +
                '}';
    }
}

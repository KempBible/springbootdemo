package test.尚学谷.bilibili_2_对象.super使用;

public class Person {

    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("Person eat");
    }

    public void study(){
        System.out.println("Person study");
    }

}

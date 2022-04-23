package test.Java8新特性.不了解Optional类简历上别说你懂Java8;

import java.util.Optional;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 17:28
 */
public class Person8 {
    private String name;
    private int age;
    private String password;

    public Person8(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
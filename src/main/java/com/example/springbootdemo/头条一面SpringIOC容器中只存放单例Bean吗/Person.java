package com.example.springbootdemo.头条一面SpringIOC容器中只存放单例Bean吗;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {

    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}

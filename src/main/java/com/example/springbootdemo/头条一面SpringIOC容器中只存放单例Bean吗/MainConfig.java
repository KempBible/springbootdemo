package com.example.springbootdemo.头条一面SpringIOC容器中只存放单例Bean吗;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig {
    @Bean("person")
    @Scope("prototype")
    public Person person(){
        System.out.println("给容器中添加Person...");
        return new Person("张三", 25);
    }
}

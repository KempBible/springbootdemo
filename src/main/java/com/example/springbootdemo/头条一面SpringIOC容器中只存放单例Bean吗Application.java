package com.example.springbootdemo;

import com.example.springbootdemo.头条一面SpringIOC容器中只存放单例Bean吗.MainConfig;
import com.example.springbootdemo.头条一面SpringIOC容器中只存放单例Bean吗.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class 头条一面SpringIOC容器中只存放单例Bean吗Application {
    public static void  main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);
        if(person.equals(person2)){
            System.out.println("同一个实例");
        }else{
            System.out.println("不同的实例");
        }
    }
}

package test.尚学谷.bilibili_2_对象;

import java.util.Date;

/**
 * 面试题：==和equals（）区别
 * 一、回顾==的使用
 * ==：运算符
 * 1.可以使用在基本数据类型类型变量和引用数据类型变量中
 * 2.如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
 *   如果比较的是引用数据类型变量：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
 *
 * 二、equals（）方法的使用：
 * 1.是一个方法，而非运算符
 * 2.只能适用于引用数据类型
 * 3.Object类中equals()的定义：
 *  public boolean equals(Object obj){
 *      return (this == obj);
 *  }
 *  说明：Object类中定义的equals()和==的作用是相同的：比较
 *
 */
public class EqualsTest {

    public static void main(String[] args) {

        // 基本数据类型
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j); // true
        System.out.println(i == d); // true

        boolean b = true;
//        System.out.println(i == b);

        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2); // true

        // 引用类型
        Customer cust1 = new Customer("Tom", 21);
        Customer cust2 = new Customer("Tom", 21);
        System.out.println(cust1 == cust2); // false

        String str1 = new String("kemp");
        String str2 = new String("kemp");
        System.out.println(str1 == str2); // false
        System.out.println("****************************");
        System.out.println(cust1.equals(cust2)); // false
        System.out.println(str1.equals(str2)); // true

        Date date1 = new Date(32432525324L);
        Date date2 = new Date(32432525324L);
        System.out.println(date1.equals(date2)); // true
    }
}

class Customer{
    String name;
    int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

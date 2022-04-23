package test.Java8新特性;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.jianshu.com/p/b7313ef988ce
 */
public class Stream中的toMap {

    public static List<User> getUserList(){
        User user1 = new User();
        user1.setId(1);
        user1.setName("a");

        User user2 = new User();
        user2.setId(2);
        user2.setName("b");

        User user3 = new User();
        user3.setId(3);
        user3.setName("c");

        User user4 = new User();
        user4.setId(4);
        user4.setName("d");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        return userList;
    }

    public static List<Person> getPersonList(){
        Person person1 = new Person();
        person1.setId("1");
        person1.setName("a");

        Person person2 = new Person();
        person2.setId("2");
        person2.setName("b");

        Person person3 = new Person();
        person3.setId("3");
        person3.setName("c");

        Person person4 = new Person();
        person4.setId("4");
        person4.setName("d");
        Person person5 = new Person();
        person5.setId("4");
        person5.setName("d");

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        return personList;
    }

    // 1、指定key-value，value是对象中的某个属性值。
    @Test
    public void test1(){
        Map<Integer, String> userMap1 = getUserList().stream().collect(Collectors.toMap(User::getId, User::getName));
        System.out.println(userMap1);
    }

    // 2、指定key-value，value是对象本身，User->User 是一个返回本身的lambda表达式
    @Test
    public void test2(){
        Map<Integer, User> userMap2 = getUserList().stream().collect(Collectors.toMap(User::getId, User->User));
        System.out.println(userMap2);
    }

    // 3、指定key-value，value是对象本身，Function.identity()是简洁写法，也是返回对象本身
    @Test
    public void test3(){
        Map<Integer, User> userMap3 = getUserList().stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(userMap3);
    }

    // 4、指定key-value，value是对象本身，Function.identity()是简洁写法，也是返回对象本身，key 冲突的解决办法，这里选择第二个key覆盖第一个key。
    @Test
    public void test4(){
        Map<Integer, User> userMap4 = getUserList().stream().collect(Collectors.toMap(User::getId, Function.identity(), (key1, key2) -> key2));
        System.out.println(userMap4);
    }

    // 5.重复时将前面的value 和后面的value拼接起来；
    @Test
    public void test5(){
        Map<String, String> map = getPersonList().stream().collect(Collectors.toMap(Person::getId, Person::getName, (key1, key2)->key1+","+key2));
        System.out.println(map);
    }

    // 6.重复时将重复key的数据组成集合
    @Test
    public void test6(){
        Map<String, List<String>> map = getPersonList().stream().collect(Collectors.toMap(Person::getId, p -> {
           List<String> getNameList = new ArrayList<>();
           getNameList.add(p.getName());
           return getNameList;
        },(List<String> value1, List<String> value2) -> {
            value1.addAll(value2);
            return value1;
        }));
        System.out.println(map);
    }
}

class Person{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class User{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
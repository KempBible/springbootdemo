package test.比较器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://blog.csdn.net/weixin_44602460/article/details/117731127
public class PersonTest1 {
    public static void main(String[] args) {
        List<Person1> list = new ArrayList<>();
        list.add(new Person1("小玲羔", 20));
        list.add(new Person1("玲羔", 22));
        list.add(new Person1("小灵狗", 24));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}

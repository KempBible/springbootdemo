package test.比较器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://blog.csdn.net/weixin_44602460/article/details/117731127
public class PersonTest2 {
    public static void main(String[] args) {
        List<Person2> list = new ArrayList<>();
        list.add(new Person2("a", 2));
        list.add(new Person2("a", 4));
        list.add(new Person2("b", 4));
        System.out.println(list);
        Collections.sort(list, new PersonComparator());
        System.out.println(list);
    }
}

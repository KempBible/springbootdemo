package test.比较器;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Comparator;

//https://blog.csdn.net/weixin_44602460/article/details/117731127
@Data
@ToString
@AllArgsConstructor
public class Person2 {
    private String name;
    private int age;
}

class PersonComparator implements Comparator<Person2> {

    @Override
    public int compare(Person2 o1, Person2 o2) {
        int i = o2.getName().compareTo(o1.getName());
        if (i == 0){
           if (o2.getAge() > o1.getAge()){
               i = 1;
           }
            if (o2.getAge() < o1.getAge()){
                i = -1;
            }
            if (o2.getAge() == o1.getAge()){
                i = 0;
            }
        }
        return i;
    }
}

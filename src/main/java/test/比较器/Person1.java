package test.比较器;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

//https://blog.csdn.net/weixin_44602460/article/details/117731127
@Data
@ToString
@AllArgsConstructor
public class Person1 implements Comparable<Person1> {
    private String name;
    private int age;
    @Override
    public int compareTo(Person1 o) {
        int num = 0;
        num = name.compareTo(o.getName()); // 使用字符串的比较
        if (num == 0){ // 如果名字一样,比较年龄, 返回比较年龄结果
            num = this.age-o.getAge();
        }
        return num; // 名字不一样, 返回比较名字的结果.
    }
}

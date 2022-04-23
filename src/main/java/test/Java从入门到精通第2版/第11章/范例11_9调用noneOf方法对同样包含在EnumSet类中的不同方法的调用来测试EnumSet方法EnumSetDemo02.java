package test.Java从入门到精通第2版.第11章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53

import java.util.EnumSet;
import java.util.Iterator;

enum Color3{
    红色, 绿色, 蓝色;
}
public class 范例11_9调用noneOf方法对同样包含在EnumSet类中的不同方法的调用来测试EnumSet方法EnumSetDemo02 {
    public static void main(String[] args) {
        EnumSet enumSet = EnumSet.noneOf(Color3.class); //表示此类型的空集合
        Iterator iterator = enumSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}


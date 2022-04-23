package test.Java从入门到精通第2版.第11章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53

import java.util.EnumSet;
import java.util.Iterator;

enum Color2{
    红色, 绿色, 蓝色;
}
public class 范例11_8测试EnumSet静态方法allOfEnumSetDemo01 {
    public static void main(String[] args) {
        EnumSet enumSet = EnumSet.allOf(Color2.class); // 表示讲枚举全部的内容设置到集合
        Iterator iterator = enumSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());;
        }
        /*
            红色
            绿色
            蓝色
         */
    }
}


package test.尚学谷.bilibili_4_常用类;

import org.junit.jupiter.api.Test;

public class String的不可变性_450 {

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        String s8 = s3.intern(); // 返回值得到的s8使用的常量值中已经存在的"javaEEhadoop"
        System.out.println(s3 == s8); // true

        String s8_1 = s5.intern(); // 返回值得到的s8使用的常量值中已经存在的"javaEEhadoop"
        System.out.println(s3 == s8_1); // true

        String s8_2 = s5.intern(); // 返回值得到的s8使用的常量值中已经存在的"javaEEhadoop"
        System.out.println(s3 == s8_2); // true
    }

    /**
     * 结论：
     * 1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
     * 2.只要其中有一个是变量，结果就在堆中
     * 3.如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test4(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3); // false

        final String s4 = "javaEE"; // s4：常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5); // true
     }
}

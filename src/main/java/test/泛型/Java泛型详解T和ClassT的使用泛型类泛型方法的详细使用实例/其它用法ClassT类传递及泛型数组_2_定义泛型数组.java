package test.泛型.Java泛型详解T和ClassT的使用泛型类泛型方法的详细使用实例;

import java.util.Arrays;

// https://www.cnblogs.com/jpfss/p/9928747.html
public class 其它用法ClassT类传递及泛型数组_2_定义泛型数组 {

    // 定义
    public static <T> T[] fun1(T...arg){ // 接收可变参数
        return arg; // 返回泛型数组
    }

    // 使用
    public static void main(String[] args) {
        Integer[] i = fun1(1,2,3,4,5,6);
        System.out.println(Arrays.toString(i));
    }
}


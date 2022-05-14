package test.Java从入门到精通第2版.第17章;

import java.util.Date;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck98f3284021498f137082c2e
public class 范例17_8根据对象找到类TestReflection {
    public static void main(String[] args) {
        Date date = new Date();
        Class<?> cla = date.getClass(); // 通过Java反射机制得到类的包名
        System.out.println(cla);
    }
}

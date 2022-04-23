package test.尚学谷.bilibili_4_常用类;

import org.junit.jupiter.api.Test;

public class StringMethodTest {

    @Test
    public void test(){
        String s1 = "HelloWorld";
        System.out.println(s1.length()); // 10
        System.out.println(s1.charAt(0)); // H
        System.out.println(s1.charAt(9)); // d
//        System.out.println(s1.charAt(10));
//        s1 = "";
        System.out.println(s1.isEmpty()); // false

        String s2 = s1.toLowerCase();
        System.out.println(s1); // HelloWorld s1不可变的，仍然为原来的字符串
        System.out.println(s2); // helloworld 改成小写以后的字符串

        String s3 = " he llo world ";
        String s4 = s3.trim();
        System.out.println("---" + s3 + "---");
        System.out.println("---" + s4 + "---");
    }

    @Test
    public void test4(){
        String str1 = "北京尚硅谷教育北京";
        String str2 = str1.replace('北', '东');

        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);

        System.out.println("---------------------------");
        String str = "12hello34world5java7891mysql456";
        // 把字符串中的数字替换成,，如果结果中开头和结尾有,的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string); // hello,world,java,mysql

        str = "12345";
        // 判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches); // true
        String tel = "0571-4534289";
        // 判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result); // true

        System.out.println("---------------------------");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
}

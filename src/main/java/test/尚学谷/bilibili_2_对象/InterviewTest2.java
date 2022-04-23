package test.尚学谷.bilibili_2_对象;

import org.junit.jupiter.api.Test;

public class InterviewTest2 {

    @Test
    public void test1(){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1); // 1.0
    }

    @Test
    public void test2(){
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2); // 1
    }

    @Test
    public void test3(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j); // false
    }
}

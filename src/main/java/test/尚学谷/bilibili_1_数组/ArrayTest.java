package test.尚学谷.bilibili_1_数组;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayTest {

    String[] arr = new String[]{"JJ", "DD", "MM", "BB", "GG", "AA"};

    // 数组的复制（区别于数组变量的赋值：arr1 = arr）
    @Test
    public void test1(){
        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        System.out.println(Arrays.toString(arr1));
    }

    // 数组的反转
    @Test
    // 方法一：
    public void test2(){
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i - 1] = temp;
        }
    }
    // 方式二：
    @Test
    public void test2_1(){
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    // 遍历
    @Test
    public void test3(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}

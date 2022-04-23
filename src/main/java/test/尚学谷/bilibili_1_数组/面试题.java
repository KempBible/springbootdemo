package test.尚学谷.bilibili_1_数组;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 面试题 {

    /**
     * 一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1+2+3。
     * 编程找出1000以内的所有完数。（因子：除去这个数本身的其他约数）
     */
    @Test
    public void test1(){
        for (int i = 0; i <= 1000; i++) {
            int factor = 0;
            for (int j = 1; j <= i/2; j++) {
                if (i % j == 0){
                    factor += j;
                }
            }
            if (i == factor){
                System.out.println(i);
            }
            // 重置factor
            // factor = 0;
        }
    }

    /**
     * ******
     * *****
     * ***
     * **
     * *
     * 外层循环控制行数
     * 内层循环控制列数
     */
    @Test
    public void test2(){
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 7 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    @Test
    public void test3(){
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 6 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，
     * 然后求出所有元素的最大值，最小值，和值，平均值，并输出出来
     * 要求：所有随机数都是两位数
     * 提示：
     * [0,1)*90 -> [0,90)+10 -> [10,100) -> [10,99)
     * [10,99]
     * 公式：(int)(Math.random() * (99 -10 + 1) + 10)
     */
    @Test
    public void test4(){
       // Math.random() : [0.0, 1)
       // Math.random() * 90 : [0.0, 90.0)
       // (int)(Math.random() * 90) : [0, 89]
       // (int)(Math.random * 90 + 10) : [10, 99]
       // 公式：获取[a,b]范围的随机数：(int)(Mth.random() * (b - a + 1)) + a
    }
    @Test
    public void test5(){
        int[] arr = new int[10];
        // [10,99]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (99 - 10 + 1) + 10);
        }
        System.out.println(Arrays.toString(arr));
    }
}

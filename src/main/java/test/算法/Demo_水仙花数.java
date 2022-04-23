package test.算法;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 11:18
 */
public class Demo_水仙花数 {
    public static void main(String[] args) {
        for (int num = 100; num <= 1000; num++) {
            int a = num / 100;
            int b = num / 10 % 10;
            int c = num % 10;
            if ((a * a * a + b * b * b + c * c * c) == num) {
                System.out.println(num);
            }
        }
    }
}
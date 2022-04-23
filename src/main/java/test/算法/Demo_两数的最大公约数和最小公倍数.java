package test.算法;

import java.util.Scanner;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 11:28
 */
public class Demo_两数的最大公约数和最小公倍数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入第一个数：");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个数：");
        int num2 = scanner.nextInt();

        int commonDivisor = 1;
        int minNum = num1 <= num2 ? num1 : num2;
        //最大公约数
        for (int i = 1; i <= minNum; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                commonDivisor = i;
                continue;
            }
        }
        System.out.println(commonDivisor);

        int leastCommonMultiple = num1 * num2;
        int maxNum = num1 >= num2 ? num1 : num2;
        //最小公倍数
        for (int i = leastCommonMultiple; i >= maxNum; i--) {
            if (i % num1 == 0 && i % num2 == 0) {
                leastCommonMultiple = i;
            }
        }
        System.out.println(leastCommonMultiple);
    }
}
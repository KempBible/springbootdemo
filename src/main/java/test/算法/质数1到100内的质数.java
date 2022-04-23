package test.算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 9:34
 */
public class 质数1到100内的质数 {
    public static void main(String[] args) {

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    continue;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        System.out.println(result);
    }

}
package test.算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 9:34
 */
public class 奇数1到100内的奇数 {
    public static void main(String[] args) {

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                result.add(i);
            }
        }
        System.out.println(result);
    }

}
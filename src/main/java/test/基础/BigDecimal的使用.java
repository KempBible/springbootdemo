package test.基础;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 13:28
 */
public class BigDecimal的使用 {
    public static void main(String[] args) {
        BigDecimal bm = BigDecimal.valueOf(456);
        System.out.println(bm);

        BigDecimal b1 = new BigDecimal(0.2);
        BigDecimal b2 = new BigDecimal(0.1);
        int c = b2.compareTo(b1);  // -1
        System.out.println(c);

        Optional.ofNullable(null);
    }
}
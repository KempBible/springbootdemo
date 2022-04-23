package test.基础;

import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/9 21:00
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(null + "");
        System.out.println((null + "") instanceof String);
        System.out.println(Objects.isNull(null + ""));
        System.out.println(null + "");
        System.out.println(StringUtils.isEmpty(null + ""));
    }

    @Test
    public void test1() {
        Boolean boon = new Boolean("TrUe");
        System.out.println(boon);
    }

    @Test
    public void test2() {
        float a = 1.0F - 0.9F;
        float b = 0.9F - 0.8F;
        if (a == b) {
            System.out.println(a == b);
        }

        Float x = Float.valueOf(a);
        Float y = Float.valueOf(b);
        if (x.equals(y)) {
            System.out.println(a == b);
        }
    }
}
package test.Java8新特性;

import java.util.stream.LongStream;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/17 20:44
 */
public class 关于并行流与串行流你必须掌握这些 {
    public static void main(String[] args) {
        System.out.println(LongStream.rangeClosed(0, 10000000L).parallel().reduce(0, Long::sum));
    }
}
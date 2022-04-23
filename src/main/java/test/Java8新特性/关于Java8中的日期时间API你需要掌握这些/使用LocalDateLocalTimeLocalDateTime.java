package test.Java8新特性.关于Java8中的日期时间API你需要掌握这些;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 18:22
 */
public class 使用LocalDateLocalTimeLocalDateTime {
    public static void main(String[] args) {
        // 获取当前系统时间
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);

        // 指定日期时间
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, 10, 01, 18, 00, 01);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime1.plusYears(3).minusDays(3);
        System.out.println(localDateTime3);

        System.out.println(localDateTime1.getYear());
        System.out.println(localDateTime1.getMonthValue());
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getHour());
        System.out.println(localDateTime1.getMinute());
        System.out.println(localDateTime1.getSecond());

        LocalDateTime localDateTime4 = LocalDateTime.now();
        System.out.println(localDateTime4);
        LocalDateTime localDateTime5 = localDateTime4.withDayOfMonth(10);
        System.out.println(localDateTime5);
    }
}
package test.Java8新特性.关于Java8中的日期时间API你需要掌握这些;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 19:18
 */
public class 日期的操纵 {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);

        // 获取这个第一天的日期
        System.out.println(localDateTime1.with(TemporalAdjusters.firstDayOfMonth()));
        // 获取下个周末的日期
        System.out.println(localDateTime1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));

        // 自定义：下一个工作日
        LocalDateTime localDateTime2 = localDateTime1.with(l -> {
            LocalDateTime localDateTime = (LocalDateTime) l;
            DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return localDateTime.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return localDateTime.plusDays(2);
            } else {
                return localDateTime.plusDays(1);
            }
        });
        System.out.println(localDateTime2);
    }
}
package test.Java8新特性.关于Java8中的日期时间API你需要掌握这些;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 18:37
 */
public class Duration和Period {

    public static void main(String[] args) {
        Instant instant_1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant_2 = Instant.now();

        Duration duration = Duration.between(instant_1, instant_2);
        System.out.println(duration.toMillis());

        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime12 = LocalTime.now();
        System.out.println(Duration.between(localTime1, localTime12).toMillis());

        LocalDate localDate1 = LocalDate.of(2020, 1, 6);
        LocalDate localDate2 = LocalDate.now();

        Period period = Period.between(localDate1, localDate2);
        System.out.println(period.getYears());
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        long result = ChronoUnit.DAYS.between(localDate1, localDate2);
        System.out.println(result);
    }
}
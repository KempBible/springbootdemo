package test.java方法工具.时间工具;

import java.time.*;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 11:39
 */
public class LocalDate和LocalTime和LocalDateTime对比 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(Instant.now());

        System.out.println(Duration.ofSeconds(21));
    }
}
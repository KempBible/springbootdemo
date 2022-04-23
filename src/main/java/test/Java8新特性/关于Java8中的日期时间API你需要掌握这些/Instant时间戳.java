package test.Java8新特性.关于Java8中的日期时间API你需要掌握这些;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 18:30
 */
public class Instant时间戳 {

    public static void main(String[] args) {
        Instant instant1 = Instant.now();
        System.out.println(instant1);

        OffsetDateTime offsetDateTime = instant1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        System.out.println(instant1.toEpochMilli());

        Instant instant2 = Instant.ofEpochSecond(60);
        System.out.println(instant2);
    }

}
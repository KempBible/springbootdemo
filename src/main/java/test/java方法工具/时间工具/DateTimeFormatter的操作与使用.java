package test.java方法工具.时间工具;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName Main
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/4 14:32
 */
// https://www.cnblogs.com/MrRightZhao/p/12005137.html
public class DateTimeFormatter的操作与使用 {
    public static void main(String[] args) {
        testStringToLocalDate();
        testLocalDateToString();
    }

    // 1.字符串转换成日期时间类型
    private static void testStringToLocalDate() {
        // String --> LocalDate
        LocalDate localDate = LocalDate.parse("2022-01-06");
        System.out.println(localDate);

        // String --> LocalTime
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(LocalDate.parse("2019-10-09").format(pattern));

        // String -->LocalDateTime
        LocalTime localTime = LocalTime.parse("07:56:05");
        System.out.println(localTime);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"); // 12小时
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 24小时
        LocalDate localDate1 = LocalDate.parse("2019-12-08 07:05:34", formatter);
        System.out.println(localDate1);

        LocalTime localTime1 = LocalTime.parse("2019-12-08 07:05:34", formatter);
        System.out.println(localTime1);
    }

    // 2.日期时间类型转换成字符串
    private static void testLocalDateToString() {
        //localDate --> String
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        String format1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE); // yyyyMMdd
        String format2 = localDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(format1);
        System.out.println(format2);

        //2.LocalTime  --> String
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        String format3 = localTime.format(DateTimeFormatter.ISO_TIME);
        System.out.println(format3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String format4 = localTime.format(formatter);
        System.out.println(format4);

        System.out.println(LocalDateTime.of(2022, 01, 06, 15, 15, 04).format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss")));
        ;
    }
}

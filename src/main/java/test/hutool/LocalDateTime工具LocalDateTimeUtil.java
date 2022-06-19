package test.hutool;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LocalDateTime工具LocalDateTimeUtil {

    @Test
    public void 日期转换(){
        String dateStr = "2022-06-18T12:23:56";
        DateTime dt = DateUtil.parse(dateStr);
        System.out.println(dt);

        // Date对象转换为LocalDateTime
        LocalDateTime of = LocalDateTimeUtil.of(dt);
        System.out.println(of);

        // 时间戳转换为LocalDateTime
        of = LocalDateTimeUtil.ofUTC(dt.getTime());
        System.out.println(of);
    }

    @Test
    public void 日期字符串解析(){
        // 解析ISO时间
        LocalDateTime localDateTime = LocalDateTimeUtil.parse("2022-06-18T17:40:00");
        System.out.println(localDateTime);

        // 解析自定义格式时间
        localDateTime = LocalDateTimeUtil.parse("2020-01-23", DatePattern.NORM_DATE_FORMATTER);
        System.out.println(localDateTime);

        //解析同样支持LocalDate
        LocalDate localDate = LocalDateTimeUtil.parseDate("2022-06-18");

        // 解析日期时间为LocalDate，时间部分舍弃
        localDate = LocalDateTimeUtil.parseDate("2020-01-23T12:23:56", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(localDate);
    }

    @Test
    public void 日期格式化(){
        LocalDateTime localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");
        System.out.println(localDateTime);

        // "2020-01-23 12:23:56"
        String format = LocalDateTimeUtil.format(localDateTime, DatePattern.NORM_DATETIME_PATTERN);
        System.out.println(format);
    }

    @Test
    public void 日期偏移(){
        final LocalDateTime localDateTime = LocalDateTimeUtil.parse("2020-01-23T12:23:56");

        // 增加一天
        // "2020-01-24T12:23:56"
        LocalDateTime offset = LocalDateTimeUtil.offset(localDateTime, 1, ChronoUnit.DAYS);
        System.out.println(offset);

        //如果是减少时间，offset第二个参数传负数即可：
        offset = LocalDateTimeUtil.offset(localDateTime, -1, ChronoUnit.DAYS);
        System.out.println(offset);
    }

    @Test
    public void 计算时间间隔(){
        LocalDateTime start = LocalDateTimeUtil.parse("2021-06-18T12:00:00");
        System.out.println(start);

        LocalDateTime end = LocalDateTimeUtil.parse("2022-06-18T12:00:00");
        System.out.println(end);

        Duration between = LocalDateTimeUtil.between(start, end);
        System.out.println(between.toDays());
    }

    @Test
    public void 一天的开始和结束(){
        LocalDateTime localDateTime = LocalDateTimeUtil.parse("2022-06-18T12:00:00");
        System.out.println(localDateTime);

        // "2020-01-23T00:00"
        LocalDateTime beginOfDay = LocalDateTimeUtil.beginOfDay(localDateTime);
        System.out.println(beginOfDay);

        // "2020-01-23T23:59:59.999999999"
        LocalDateTime endOfDay = LocalDateTimeUtil.endOfDay(localDateTime);
        System.out.println(endOfDay);


    }
}

package test.Java8新特性.关于Java8中的日期时间API你需要掌握这些;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 19:32
 */
public class 时区的处理 {
    public static void main(String[] args) {
        // 获取所有的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        System.out.println(set);

        // 通过时区构建LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(localDateTime);

        // 以时区格式显示时间
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = localDateTime1.atZone(ZoneId.of("Africa/Nairobi"));
        System.out.println(zonedDateTime1);
    }
}
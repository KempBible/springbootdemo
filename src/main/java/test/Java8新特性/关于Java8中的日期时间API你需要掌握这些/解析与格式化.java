package test.Java8新特性.关于Java8中的日期时间API你需要掌握这些;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/18 19:26
 */
// https://mp.weixin.qq.com/s?__biz=Mzg4MjU0OTM1OA==&mid=2247489312&idx=1&sn=5c708966e3184c0b615b8ca8346297eb&chksm=cf55a021f8222937b3cc63332902bbcc8bb34057c757b4e02a6ef9fdcc1a336fc3af858c8657&scene=178&cur_album_id=1664766497224753159#rd
public class 解析与格式化 {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ISO_DATE;
        LocalDateTime localDateTime = LocalDateTime.now();
        String strDate1 = localDateTime.format(dateTimeFormatter1);
        System.out.println(strDate1);

        // Date -> String
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate2 = dateTimeFormatter2.format(localDateTime);
        System.out.println(strDate2);

        // String -> Date
        LocalDateTime localDateTime1 = LocalDateTime.parse(strDate2, dateTimeFormatter2);
        System.out.println(localDateTime1);
    }
}
package test.java方法工具.时间工具;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName LocalDateTime用法
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/6 10:53
 */
// https://www.cnblogs.com/mark5/p/11865833.html
public class LocalDateTime用法 {
    public static void main(String[] args) {
        获取当前时间();
        根据指定日期_时间创建对象();
        日期时间的加减();
        将年月日等修改为指定的值并返回新的日期时间对象();
        获取日期的年月日周时分秒();
        时间日期前后的比较与判断();
        判断是否为闰年();
        java8时钟clock();
        时间戳();
        计算时间日期间隔();
        当计算程序的运行时间时应当使用时间戳Instant();
        使用jdk自身配置好的日期格式();
        使用自定义格式();
        将时间字符串形式转化为日期对象();
        将时间日期对象转为格式化后的时间日期对象();
        long毫秒值转换为日期();
    }

    private static void 获取当前时间() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    private static void 根据指定日期_时间创建对象() {
        LocalDate localDate = LocalDate.of(2022, 1, 13);
        LocalTime localTime = LocalTime.of(5, 46, 20);
        LocalDateTime localDateTime = LocalDateTime.of(2022, 01, 06, 15, 25, 56);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    /**
     * 对于LocalDate,只有精度大于或等于日的加减，如年、月、日；
     * 对于LocalTime,只有精度小于或等于时的加减，如时、分、秒、纳秒；
     * 对于LocalDateTime,则可以进行任意精度的时间相加减；
     **/
    private static void 日期时间的加减() {
        LocalDateTime localDateTime = LocalDateTime.now();
        //以下方法的参数都是long型，返回值都是LocalDateTime
        LocalDateTime plusYearsResult = localDateTime.plusYears(2L);
        LocalDateTime plusMonthsResult = localDateTime.plusMonths(3L);
        LocalDateTime plusDaysResult = localDateTime.plusDays(7L);
        LocalDateTime plusHoursResult = localDateTime.plusHours(2L);
        LocalDateTime plusMinutesResult = localDateTime.plusMinutes(10L);
        LocalDateTime plusSecondsResult = localDateTime.plusSeconds(10L);

        System.out.println("当前时间是：" + localDateTime + "\n"
                + "当前时间加2年后为 : " + plusYearsResult + "\n"
                + "当前时间加3个月后为 : " + plusMonthsResult + "\n"
                + "当前时间加7日后为 : " + plusDaysResult + "\n"
                + "当前时间加2小时后为 : " + plusHoursResult + "\n"
                + "当前时间加10分钟后为 : " + plusMinutesResult + "\n"
                + "当前时间加10秒后为 : " + plusSecondsResult + "\n"
        );

        // 也可以以另一种方式来相加减日期，即plus(long amountToAdd, TemporalUnit unit)
        // 参数1 ： 相加的数量， 参数2 ： 相加的单位
        LocalDateTime nextMonth = localDateTime.plus(1, ChronoUnit.MONTHS);
        LocalDateTime nextYear = localDateTime.plus(1, ChronoUnit.YEARS);
        LocalDateTime nextWeek = localDateTime.plus(1, ChronoUnit.WEEKS);

        System.out.println("now : " + localDateTime + "\n"
                + "nextYear : " + nextYear + "\n"
                + "nextMonth : " + nextMonth + "\n"
                + "nextWeek :" + nextWeek + "\n"
        );

        //日期的减法用法一样，在此不再举例
    }

    /**
     * 析： 其效果与时间日期相加减差不多，如今天是2018-01-13，要想变为2018-01-20有两种方式
     * a. localDate.plusDays(20L) -> 相加指定的天数
     * b. localDate.withDayOfYear(20) -> 直接指定到哪一天
     **/
    private static void 将年月日等修改为指定的值并返回新的日期时间对象() {
        LocalDate localDate = LocalDate.now();
        // 当前时间基础上，指定本年当中的第几天，取值范围为1-365,366
        LocalDate withDayOfYearResult = localDate.withDayOfYear(200);
        System.out.println(withDayOfYearResult);

        // 当前时间基础上，指定本月当中的第几天，取值范围为1-29,30,31
        LocalDate withDayOfMonthResult = localDate.withDayOfMonth(5);
        System.out.println(withDayOfMonthResult);

        //当前时间基础上，直接指定年份
        LocalDate withYearResult = localDate.withYear(2017);
        System.out.println(withYearResult);

        // 当前时间基础上，直接指定月份
        LocalDate withMonthResult = localDate.withMonth(5);
        System.out.println(withMonthResult);
    }

    private static void 获取日期的年月日周时分秒() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int dayOfYear = localDateTime.getDayOfYear();
        int dayOfMonth = localDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println("今天是" + localDateTime + "\n"
                + "本年当中第" + dayOfYear + "天" + "\n"
                + "本月当中第" + dayOfMonth + "天" + "\n"
                + "本周中星期" + dayOfWeek.getValue() + "-即" + dayOfWeek + "\n");

        //获取当天时间的年月日时分秒
        int year = localDateTime.getYear();
        Month month = localDateTime.getMonth();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println("今天是" + localDateTime + "\n"
                + "年 ： " + year + "\n"
                + "月 ： " + month.getValue() + "-即 " + month + "\n"
                + "日 ： " + day + "\n"
                + "时 ： " + hour + "\n"
                + "分 ： " + minute + "\n"
                + "秒 ： " + second + "\n"
        );
    }

    private static void 时间日期前后的比较与判断() {
        //判断两个时间点的前后
        LocalDate localDate1 = LocalDate.of(2017, 8, 06);
        LocalDate localDate2 = LocalDate.of(2018, 8, 8);
        boolean date1IsBefore2 = localDate1.isBefore(localDate2);
        System.out.println("dateIsBeforeDate2：" + date1IsBefore2);
    }

    private static void 判断是否为闰年() {
        LocalDate now = LocalDate.now();
        System.out.println("now : " + now + ", is leap year ? " + now.isLeapYear());
    }

    private static void java8时钟clock() {
        //返回当前时间，根据系统时间和UTC
        Clock clock = Clock.systemUTC();
        // 运行结果： SystemClock[Z]
        System.out.println(clock);
    }

    /**
     * 事实上Instant就是java8以前的Date，
     * 可以使用以下两个类中的方法在这两个类型之间进行转换，
     * 比如Date.from(Instant)就是用来把Instant转换成java.util.date的，
     * 而new Date().toInstant()就是将Date转换成Instant的
     **/
    private static void 时间戳() {
        Instant instant = Instant.now();
        System.out.println(instant);
        Date date = Date.from(instant);
        System.out.println(date);

        Instant instant1 = date.toInstant();
        System.out.println(instant1);
    }

    /*
     * Duration:用于计算两个“时间”间隔
     * Period:用于计算两个“日期”间隔
     **/
    private static void 计算时间日期间隔() {
        //计算两个日期的日期间隔-年月日
        LocalDate localDate1 = LocalDate.of(2013, 1, 4);
        LocalDate localDate2 = LocalDate.now();
        //内部是用date2-date1，所以得到的结果是负数
        Period period = Period.between(localDate2, localDate1);
        System.out.println(period);
        System.out.println("相差年数 :" + period.getYears());
        System.out.println("相差月数 :" + period.getMonths());
        System.out.println("相差天数 :" + period.getDays());

        //还可以这样获取相差的年月日
        System.out.println("-------------------------------");
        long years = period.get(ChronoUnit.YEARS);
        long months = period.get(ChronoUnit.MONTHS);
        long days = period.get(ChronoUnit.DAYS);

        System.out.println("相差的年月日分别为 ： " + years + ", " + months + ", " + days);
        //注意，当获取两个日期的间隔时，并不是单纯的年月日对应的数字相加减，而是会先算出具体差多少天，在折算成相差几年几月几日的

        //计算两个时间的间隔
        System.out.println("-------------------------------");
        LocalDateTime date3 = LocalDateTime.now();
        LocalDateTime date4 = LocalDateTime.of(2013, 1, 4, 22, 30, 10);
        Duration duration = Duration.between(date3, date4);
        System.out.println(date3 + " 与 " + date4 + " 间隔  " + "\n"
                + " 天 :" + duration.toDays() + "\n"
                + " 时 :" + duration.toHours() + "\n"
                + " 分 :" + duration.toMinutes() + "\n"
                + " 毫秒 :" + duration.toMillis() + "\n"
                + " 纳秒 :" + duration.toNanos() + "\n"
        );
        //注意，并没有获得秒差的，但既然可以获得毫秒，秒就可以自行获取了
    }

    private static void 当计算程序的运行时间时应当使用时间戳Instant() {
        Instant instant1 = Instant.now();
        for (int i = 0; i < 1; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
        }
        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant1, instant2);
        System.out.println("程序运行时长为：" + duration.toMillis() + "毫秒");
    }

    // ********************************************************
    // 时间日期的格式化（格式化后返回的类型是String）
    private static void 使用jdk自身配置好的日期格式() {
        //使用jdk自身配置好的日期格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime date1 = LocalDateTime.now();
        //反过来调用也可以 : date1.format(formatter1);
        String date1Str = formatter1.format(date1);
        System.out.println(date1Str);
    }

    private static void 使用自定义格式() {
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String dateStr = formatter.format(data);
        System.out.println(dateStr);
        // 注：自定义转化的格式一定要与日期类型对应
        //LocalDate只能设置仅含年月日的格式
        //LocalTime只能设置仅含时分秒的格式
        //LocalDateTime可以设置含年月日时分秒的格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(formatter1.format(LocalDate.now()));
        System.out.println("-------------------------------");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(formatter2.format(LocalTime.now()));
    }

    private static void 将时间字符串形式转化为日期对象() {
        String datetime = "2018-01-13 21:27:30";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(datetime, dateTimeFormatter);
        System.out.println(localDateTime);
    }

    private static void 将时间日期对象转为格式化后的时间日期对象() {
        //新的格式化API中，格式化后的结果都默认是String，有时我们也需要返回经过格式化的同类型对象
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String temp = dateTimeFormatter.format(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.parse(temp, dateTimeFormatter);
        System.out.println(localDateTime1);
    }

    private static void long毫秒值转换为日期() {
        System.out.println("---------long毫秒值转换为日期---------");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String longToDateTime = dateTimeFormatter.format(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("Asia/Shanghai")
        ));
        System.out.println(longToDateTime);
    }
}


package test.hutool;

import cn.hutool.core.date.*;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class 日期时间工具DateUtil {

    @Test
    public void DateLongCalendar之间的相互转换(){

        //当前时间
        Date date= DateUtil.date();
        System.out.println(date);

        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println(date2);

        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println(date3);

        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println(now);

        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println(today);
    }

    @Test
    public void 字符串转日期(){

        String dateStr = "2022-01-01";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);

        String dateStr1 = "2022/01/01 12:09:21";
        Date date1 = DateUtil.parse(dateStr1);
        System.out.println(date1);

        String dateStr2 = "12:00:00";
        Date date2 = DateUtil.parse(dateStr2);
        System.out.println(date2);

        String dateStr3 = "2017-03-01";
        Date date3 = DateUtil.parse(dateStr3, "yyyy-MM-dd");
        System.out.println(date3);
    }

    @Test
    public void 格式化日期输出(){
        String dateStr = "2022-06-18";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);

        //结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");
        System.out.println(format);

        ////常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);
        System.out.println(formatDate);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);
        System.out.println(formatDateTime);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date);
        System.out.println(formatTime);
    }

    @Test
    public void 获取Date对象的某个部分(){
        Date date = DateUtil.date();
        System.out.println(date);

        //获得年的部分
        System.out.println(DateUtil.year(date));
        //获得月份，从0开始计数
        System.out.println(DateUtil.month(date));
        //获得月份枚举
        System.out.println(DateUtil.monthEnum(date));
    }

    @Test
    public void 开始和结束时间(){
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);

        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);
        System.out.println(beginOfDay);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);
        System.out.println(endOfDay);
    }

    @Test
    public void 日期时间偏移(){
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);

        //结果：2017-03-03 22:33:23
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        System.out.println(newDate);

        //常用偏移，结果：2017-03-04 22:33:23
        DateTime newDate2 = DateUtil.offsetDay(date, 3);
        System.out.println(newDate2);

        //常用偏移，结果：2017-03-01 19:33:23
        DateTime newDate3 = DateUtil.offsetHour(date, -3);
        System.out.println(newDate3);

        //昨天
        System.out.println(DateUtil.yesterday());
        //明天
        System.out.println(DateUtil.tomorrow());
        //上周
        System.out.println(DateUtil.lastWeek());
        //下周
        System.out.println(DateUtil.nextWeek());
        //上个月
        System.out.println(DateUtil.lastMonth());
        //下个月
        System.out.println(DateUtil.nextMonth());
    }

    @Test
    public void 日期时间差(){
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        System.out.println(date1);

        String dateStr2 = "2017-04-01 22:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        System.out.println(date2);

        //相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println(betweenDay);
    }

    @Test
    public void 格式化时间差(){
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);
        System.out.println(date1);

        String dateStr2 = "2017-04-01 25:33:23";
        Date date2 = DateUtil.parse(dateStr2);
        System.out.println(date2);
        //Level.MINUTE表示精确到分
        String formatBetween = DateUtil.formatBetween(date1, date2, BetweenFormatter.Level.MINUTE);
        System.out.println(formatBetween);
    }

    @Test
    public void 星座和属相(){
        // "摩羯座"
        String zodiac = DateUtil.getZodiac(Month.DECEMBER.getValue(), 19);
        System.out.println(zodiac);

        // "狗"
        String chineseZodiac = DateUtil.getChineseZodiac(1991);
        System.out.println(chineseZodiac);
    }

    @Test
    public void 其它(){
        //年龄
        System.out.println(DateUtil.ageOfNow("1991.12.3"));
        System.out.println(DateUtil.ageOfNow("1992.1.3"));

        //是否闰年
        System.out.println(DateUtil.isLeapYear(2022));
        System.out.println(DateUtil.isLeapYear(2024));
    }
}

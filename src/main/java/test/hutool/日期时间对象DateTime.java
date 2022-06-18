package test.hutool;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.Week;
import org.junit.jupiter.api.Test;
import test.尚学谷.bilibili_5_枚举与注解.Season;

import java.util.Date;

public class 日期时间对象DateTime {

    @Test
    public void 新建对象(){
        Date date = new Date();

        //new方式创建
        DateTime time = new DateTime(date);
        System.out.println(time);

        //of方式创建
        DateTime now = new DateTime();
        DateTime dt = DateTime.of(now);
        System.out.println(dt);
    }

    @Test
    public void 使用对象(){
        DateTime dateTime = new DateTime("2017-01-05 12:34:23", DatePattern.NORM_DATETIME_FORMAT);
        System.out.println(dateTime);

        //年，结果：2017
        int year = dateTime.year();
        System.out.println(year);

        //季度（非季节），结果：Season.SPRING
        Week week = dateTime.dayOfWeekEnum();
        System.out.println(week.name());
    }
}

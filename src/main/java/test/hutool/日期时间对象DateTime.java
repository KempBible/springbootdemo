package test.hutool;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.Month;
import org.junit.jupiter.api.Test;

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

        //月份，结果：Month.JANUARY
        Month month = dateTime.monthEnum();
        System.out.println(month);

        //日，结果：5
        int day = dateTime.dayOfMonth();
        System.out.println(day);
    }

    @Test
    public void 对象的可变性(){
        DateTime dateTime = new DateTime("2022-06-18 12:00:00", DatePattern.NORM_DATETIME_FORMAT);
        System.out.println(dateTime);

        //默认情况下DateTime为可变对象，此时offset == dateTime
        DateTime offset = dateTime.offset(DateField.YEAR, 0);
        System.out.println(offset);

        //设置为不可变对象后变动将返回新对象，此时offset != dateTime
        dateTime.setMutable(false);
        offset = dateTime.offset(DateField.YEAR, 0);
        System.out.println(offset);
    }

    @Test
    public void 格式化为字符串(){
        DateTime dateTime = new DateTime("2022-06-18 12:10:10", DatePattern.NORM_DATETIME_FORMAT);
        System.out.println(dateTime);

        //结果：2017-01-05 12:34:23
        String dateStr = dateTime.toString();
        System.out.println(dateStr);
    }
}

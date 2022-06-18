package test.hutool;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.Month;
import org.junit.jupiter.api.Test;

import java.util.Calendar;


public class 日期时间工具 {

    @Test
    public void 月份枚举(){
        int lastDay = Month.of(Calendar.JANUARY).getLastDay(false);
        System.out.println(lastDay);
    }

    @Test
    public void 时间枚举(){
        System.out.println(DateUnit.MINUTE);
        System.out.println(DateUnit.values());
    }
}

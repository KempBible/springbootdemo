package test.Java从入门到精通第2版.第15章;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec
public class 范例15_10判断是否闰年LeapYear {
    public static void main(String[] args) {
        //用指定的年获取一个Year
        Year year1 = Year.of(2012);
        //从Year获取YearMonth
        YearMonth yearMonth = year1.atMonth(2);
        //YearMonth指定日得到LocalDate
        LocalDate localDate2 = yearMonth.atDay(29);
        System.out.println("时间：" + localDate2);
        //判断是否是闰年
        System.out.println("是否为闰年：" + localDate2.isLeapYear());

        //自动处理闰年的2月日期
        //创建一个MonthDay
        MonthDay monthDay = MonthDay.of(2, 29);
        LocalDate leapYear = monthDay.atYear(2012);
        System.out.println("闰年：" + leapYear);
        //同一个MonthDay关联到另一个年份上
        LocalDate nonLeapYear = monthDay.atYear(2014);
        System.out.println("非闰年：" + nonLeapYear);

    }
}

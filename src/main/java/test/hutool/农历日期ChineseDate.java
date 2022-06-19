package test.hutool;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

public class 农历日期ChineseDate {

    @Test
    public void 构建ChineseDate对象(){
        //通过农历构建
        ChineseDate chineseDate = new ChineseDate(1991,10,28);
        System.out.println(chineseDate);

        //通过公历构建
        ChineseDate chineseDate1 = new ChineseDate(DateUtil.parseDate("1991-12-03"));
        System.out.println(chineseDate1);
    }

    @Test
    public void 基本使用(){
        //通过公历构建
        ChineseDate date = new ChineseDate(DateUtil.parse("2020-01-25"));
        System.out.println(date);

        // 一月
        System.out.println(date.getChineseMonth());
        // 正月
        System.out.println(date.getChineseMonthName());
        // 初一
        System.out.println(date.getChineseDay());
        // 庚子
        System.out.println(date.getCyclical());
        // 生肖：鼠
        System.out.println(date.getChineseZodiac());
        // 传统节日（部分支持，逗号分隔）：春节
        System.out.println(date.getFestivals());
        // 庚子鼠年 正月初一
        System.out.println(date.toString());
    }

    @Test
    public void 获取天干地支(){
        //通过公历构建
        ChineseDate chineseDate = new ChineseDate(DateUtil.parseDate("2022-06-18"));
        System.out.println(chineseDate);

        // 庚子年甲申月癸卯日
        String cyclicalYMD = chineseDate.getCyclicalYMD();
        System.out.println(cyclicalYMD);
    }
}

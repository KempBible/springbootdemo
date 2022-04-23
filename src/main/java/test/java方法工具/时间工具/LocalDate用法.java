package test.java方法工具.时间工具;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/10 17:53
 */
public class LocalDate用法 {
    public static void main(String[] args) {
        int daysOfThisYear = LocalDate.now().lengthOfYear();
        System.out.println(daysOfThisYear);

        LocalDate.of(2020, 2, 1).lengthOfYear();
        int daysOfThisYear1 = LocalDate.now().lengthOfYear();
        System.out.println(daysOfThisYear1);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.DECEMBER, 31);
        System.out.println(calendar.getTime());
        LocalDate endDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(endDate);
        if (endDate.isBefore(LocalDate.now())) {
            System.out.println("endDate:{}" + endDate + ",大于startDate:{}" + LocalDate.now());
        }
    }
}
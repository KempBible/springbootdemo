package test.java方法工具.时间工具;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 时间格式 {
    public static void main(String[] args) {
        SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2021);
        c.set(Calendar.MONTH, 11);

        c.set(Calendar.DATE, 25);
        System.out.println("YYYY-MM-dd:" + df1.format(c.getTime()));
        System.out.println("yyyy-MM-dd:" + df2.format(c.getTime()));

        System.out.println("--------------------------------------------");

        c.set(Calendar.DATE, 26);
        System.out.println("YYYY-MM-dd:" + df1.format(c.getTime()));
        System.out.println("yyyy-MM-dd:" + df2.format(c.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS ");
        System.out.println(sdf.format(new Date()));
    }
}

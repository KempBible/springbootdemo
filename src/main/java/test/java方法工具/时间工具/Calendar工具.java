package test.java方法工具.时间工具;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendar工具 {

    public static void main(String[] args) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println(calendar.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String ss = sdf.format(calendar.getTime());
        System.out.println(ss);

        long end = calendar.getTime().getTime() - 24 * 60 * 60 * 1000;
        calendar.setTimeInMillis(end);
        System.out.println(calendar.getTime());

        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime());
    }

}

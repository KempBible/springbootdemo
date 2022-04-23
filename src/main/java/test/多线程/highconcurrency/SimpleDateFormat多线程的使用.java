package test.多线程.highconcurrency;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: SimpleDateFormat多线程的使用
 * @author: biankunpeng
 * @date: 2021年04月16日 11:22
 */
public class SimpleDateFormat多线程的使用 {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 问题
    public static Date parse(String dateStr) {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
            Thread.sleep(10);
        } catch (ParseException | InterruptedException e) {
            e.printStackTrace();
        }
        return date;
    }

    // 方案一
    public static Date parse1(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    // 方案二
    public static synchronized Date parse2(String dateStr) {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    // 方案三
    public static DateTimeFormatter sdf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime parse3(String dateStr) {
        LocalDateTime date = LocalDateTime.parse(dateStr, sdf3);
        return date;
    }

    // 方案四
    private static ThreadLocal<DateFormat> threadLocalDateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static Date parse4(String dateStr) {
        Date date = null;
        try {
            date = threadLocalDateFormat.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //问题
        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(() -> {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, num);
                System.out.println(num + "\t" + parse(sdf.format(calendar.getTime())));
            });
        }

        //方案一
        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(() -> {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, num);
                System.out.println(num + "\t" + parse1(sdf.format(calendar.getTime())));
            });
        }

        //方案二
        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(() -> {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, num);
                System.out.println(num + "\t" + parse2(sdf.format(calendar.getTime())));
            });
        }

        //方案三
        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(() -> {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, num);
                System.out.println(num + "\t" + parse3(sdf.format(calendar.getTime())));
            });
        }

        //方案四
        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(() -> {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, num);
                System.out.println(num + "\t" + parse4(sdf.format(calendar.getTime())));
            });
        }
        service.shutdown();
    }

}

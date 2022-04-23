package test.多线程.highconcurrency;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author:
 * @date: 2021年04月16日 14:27
 */
public class ThreadVariateTest {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parse(String dataStr){
        Date date = null;
        try {
            date = sdf.parse(dataStr);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(() ->{
                System.out.println(num + " " + parse("2019-06-01 16:34:30"));
            });
        }
        service.shutdown();
    }
}

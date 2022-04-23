package test.java方法工具.时间工具;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: biankunpeng
 * @date: 2021年07月27日 19:46
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new HashedWheelTimer();
        Timeout timeout = timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("5s printed");
            }
        }, 5, TimeUnit.SECONDS);

        TimerTask task;
        TimeUnit unit;
        Timeout timeout1 = timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("7s printed");
            }
        }, 10, TimeUnit.SECONDS);

        if (!timeout.isExpired()) {
            timeout1.cancel();
        }

        timer.newTimeout(timeout1.task(), 3, TimeUnit.SECONDS);
    }
}

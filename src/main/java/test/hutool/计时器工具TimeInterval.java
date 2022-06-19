package test.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import jodd.util.ThreadUtil;
import org.junit.jupiter.api.Test;

public class 计时器工具TimeInterval {

    @Test
    public void 使用(){
        TimeInterval timer = DateUtil.timer();
        System.out.println(timer);

        //---------------------------------
        //-------这是执行过程
        //---------------------------------
        System.out.println(timer.interval());//花费毫秒数
        System.out.println(timer.intervalRestart());//返回花费时间，并重置开始时间
        System.out.println(timer.intervalMinute());//花费分钟数
    }

    @Test
    public void 也可以实现分组计时(){
        final TimeInterval timer = new TimeInterval();

        //分组1
        timer.start("1");
        ThreadUtil.sleep(800);
        System.out.println(timer.intervalMs());

        // 分组2
        timer.start("2");
        ThreadUtil.sleep(900);
        System.out.println(timer.intervalMs());
        System.out.println(timer.intervalMs("1"));
        System.out.println(timer.intervalMs("2"));
    }

}

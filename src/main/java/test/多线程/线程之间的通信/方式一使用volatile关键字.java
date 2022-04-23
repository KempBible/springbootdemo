package test.多线程.线程之间的通信;

import java.util.ArrayList;
import java.util.List;

////https://zhuanlan.zhihu.com/p/90210703?utm_source=wechat_session&utm_medium=social&utm_oi=699596515802378240&utm_campaign=shareopn
public class 方式一使用volatile关键字 {

    // 定义一个共享变量来实现通信，它需要是volatile修饰，否则线程不能及时感知
    static volatile boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 实现线程A
        Thread threadA = new Thread(() ->{
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A向list中添加一个元素，此时list中的元素个数为：" + list.size());
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (list.size() == 5){
                    notice = true;
                }
            }
        });

        // 实现线程B
        Thread threadB = new Thread(() -> {
           while (true){
               if (notice){
                   System.out.println("线程B收到通知，开始执行自己的业务...");
                   break;
               }
           }
        });

        // 需要先启动线程B
        threadB.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 再启动线程A
        threadA.start();
    }
}

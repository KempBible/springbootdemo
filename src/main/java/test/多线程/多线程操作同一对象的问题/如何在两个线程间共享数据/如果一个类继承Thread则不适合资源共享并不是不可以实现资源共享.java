package test.多线程.多线程操作同一对象的问题.如何在两个线程间共享数据;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 15:34
 */
//生产者与消费者问题
public class 如果一个类继承Thread则不适合资源共享并不是不可以实现资源共享 {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        baoZi.pier = "荞麦面";
        baoZi.xianer = "鲜虾";

        BaoZiPu baoZiPu = new BaoZiPu("包子铺", baoZi);
        ChiHuo chiHuo = new ChiHuo("吃货", baoZi);

        new Thread(baoZiPu, "包子铺").start();
        new Thread(chiHuo, "吃货").start();
    }

}

// 包子资源类：
class BaoZi {
    String pier;
    String xianer;
    // 没包子
    boolean flag = false;
}

// 吃货线程类：
class ChiHuo extends Thread {
    private BaoZi bz;

    public ChiHuo(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.flag == false) { // 没包子
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃" + bz.pier + bz.xianer + "包子");
                bz.flag = false;
                bz.notify();
            }
        }

    }

}

//包子铺线程类：
class BaoZiPu extends Thread {
    private BaoZi bz;

    public BaoZiPu(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        // 造包子
        while (true) {
            // 同步
            synchronized (bz) {
                if (bz.flag = true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 没有包子 造包子
                System.out.println("包子铺开始做包子");
                if (count % 2 == 0) {
                    // 冰皮 五仁
                    bz.pier = "冰皮";
                    bz.xianer = "五仁";
                } else {
                    // 薄片 牛肉大葱
                    bz.pier = "薄片";
                    bz.xianer = "牛肉大葱";
                }
                count++;

                bz.flag = true;
                System.out.println("包子造好了" + bz.pier + bz.xianer);
                System.out.println("吃货来吧");
                // 唤醒等待线程（吃货）
                bz.notify();
            }
        }
    }
}
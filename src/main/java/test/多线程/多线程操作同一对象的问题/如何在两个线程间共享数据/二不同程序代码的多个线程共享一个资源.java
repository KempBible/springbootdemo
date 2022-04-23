package test.多线程.多线程操作同一对象的问题.如何在两个线程间共享数据;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/24 15:23
 */
public class 二不同程序代码的多个线程共享一个资源 {
    public static void main(String[] args) {
        final Bank bank = new Bank();

        Thread tadd = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bank.addMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");
                }
            }
        });

        Thread tsub = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    bank.subMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        tsub.start();
        tadd.start();
    }

}

class Bank {

    private volatile int count = 10; //账户余额

    // 存钱
    public void addMoney(int money) {
        count += money;
        System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "存进：" + money);
    }

    // 取钱
    public void subMoney(int money) {
        if (count - money < 0) {
            System.out.println("钱不够");
            return;
        }
        count -= money;
        System.out.println(Thread.currentThread().getName() + System.currentTimeMillis() + "取钱：" + money);
    }

    // 查询
    public void lookMoney() {
        System.out.println("账户余额：" + count);
    }
}
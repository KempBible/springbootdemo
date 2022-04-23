package test.尚学谷.bilibili_3_多线程;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的对象
 * 2.重写Thread类的run()-->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 * 例子：遍历100以内的所有的偶数
 */
// 1.创建一个继承于Thread类的子类
public class 创建多线程 extends Thread {
    // 2.重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        // 3.创建Thread类的子类的对象
        创建多线程 thread = new 创建多线程();

        // 4.通过此对象调用start()
        thread.start();
    }
}

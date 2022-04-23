package test.尚学谷.bilibili_3_多线程;

/**
 * 例子：创建三个窗口卖票，总票数为100张，使用实现Runnable接口的方式
 * 1.问题：卖票过程中，出现了重票、错票 -->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来，直到线程a操作完ticket时，
 *           线程才可以开始操作ticket，这种情况即使线程a出现了阻塞，也不能被改变
 * 4.在java中，我们通过同步机制，来解决线程的安全问题
 *
 * 方式一：同步代码块
 *  synchronized(同步监视器){
 *      // 需要被同步的代码
 *  }
 *  说明：1.操作共享数据的代码，即为需要被同步的代码 -->不能包含代码多了，也不能包含代码少了
 *       2.共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 *       3.同步监视器，俗称：锁，任何一个类的对象，都可以充当锁
 *          要求：多个线程必须要共用同一把锁
 *       补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
 *
 *  方式二：同步方法
 *      如果操作共享数据的代码完整的声明在一个方式中，我们不妨将此方法声明同步的
 *
 * 5.同步的方式，解决了线程的安全问题。 --好处
 *   操作同步代码时，只能有一个线程参与，其他线程等待。相当于时一个单线程的过程，效率低
 *
 */
public class Runnable创建安全多线程3_2 implements Runnable{
    private int ticket = 100;

    @Override
    public synchronized void run() {
        while (true){
            show();
        }
    }

    private void show(){
        synchronized (this){
            if (ticket > 0){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }
        }
    }

    public static void main(String[] args) {
        Runnable创建安全多线程3_2 runnable创建安全多线程3_1 = new Runnable创建安全多线程3_2();

        Thread thread1 = new Thread(runnable创建安全多线程3_1);
        Thread thread2 = new Thread(runnable创建安全多线程3_1);
        Thread thread3 = new Thread(runnable创建安全多线程3_1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

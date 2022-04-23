package test.多线程.Java中Synchronized的用法简单介绍;

public class 二当一个线程访问对象的一个synchronizedthis同步代码块时另一个线程仍然可以访问该对象中的非synchronizedthis同步代码块 {

    public static void main(String[] args) {
        System.out.println("使用关键字synchronized");
        Mthreads mt = new Mthreads();
        Thread thread1 = new Thread(mt, "mt1");
        Thread thread2 = new Thread(mt, "mt2");
        thread1.start();
        thread2.start();
    }
}

class Mthreads implements Runnable{
    private int count;

    public Mthreads() {
        count = 0;
    }

    public void countAdd(){
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    // 非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
    public void printCount(){
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " count:" + count);
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("mt1")){
            countAdd();
        }else if (threadName.equals("mt2")){
            printCount();
        }
    }
}
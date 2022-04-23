package test.多线程.Java中Synchronized的用法简单介绍;

public class 二修饰一个类 {
    public static void main(String[] args) {
        System.out.println("使用ClassName");
        SyncThread4 syncThread4 = new SyncThread4();
        Thread thread1 = new Thread(syncThread4, "SyncThread1");
        Thread thread2 = new Thread(syncThread4, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}

class ClassName{
    public void method(){
        synchronized (ClassName.class){

        }
    }
}

class SyncThread4 implements Runnable{
    private static int count;

    public SyncThread4() {
        count = 0;
    }

    public static void method(){
//        synchronized (SyncThread4.class){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
//        }
    }

    @Override
    public synchronized void run() {
        method();
    }
}
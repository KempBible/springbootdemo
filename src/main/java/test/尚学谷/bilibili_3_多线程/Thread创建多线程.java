package test.尚学谷.bilibili_3_多线程;

class Window extends Thread{

//    private int ticket = 100;
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}

public class Thread创建多线程{
    public static void main(String[] args) {
        Window window = new Window();

        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

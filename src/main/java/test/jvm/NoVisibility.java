package test.jvm;

/**
 * @ClassName NoVisibility
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/14 10:51
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    /***
     * @param null
     * @Description:
     * @author: biankunpeng
     * @Date: 2022-02-14 14:28
     * @Return:
     */
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) ;
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(10000);
    }
}

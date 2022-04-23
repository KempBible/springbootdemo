package test.尚学谷.bilibili_3_多线程;

class Bank{
    private Bank(){

    }

    private static Bank instance = null;

    public static Bank getInstance(){
        // 方法一：效率稍差
//        synchronized (Bank.class){
//            if (instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        // 方式二：效率更高
        if (instance == null){
            synchronized (Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class BankTest {

}

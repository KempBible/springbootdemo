package test.Java从入门到精通第2版.第15章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec

public class 范例15_8取得内存值GetMemorySize {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime(); //单例设计
        String str = ""; // 定义一个字符串
        for (int i = 0; i < 5000; i++) {
            str += i; // 垃圾产生
        }

        System.out.println("1.最大可用内存：" + runtime.maxMemory());
        System.out.println("1.总共可用内存：" + runtime.totalMemory());
        System.out.println("1.可用内存：" + runtime.freeMemory());
        runtime.gc(); //清理垃圾
        System.out.println("------------------------------");
        System.out.println("2.最大可用内存：" + runtime.maxMemory());
        System.out.println("2.总共可用内存：" + runtime.totalMemory());
        System.out.println("2.可用内存：" + runtime.freeMemory());
    }
}

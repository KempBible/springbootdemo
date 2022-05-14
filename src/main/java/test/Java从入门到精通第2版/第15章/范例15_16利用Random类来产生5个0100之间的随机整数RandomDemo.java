package test.Java从入门到精通第2版.第15章;

import java.util.Random;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec
public class 范例15_16利用Random类来产生5个0100之间的随机整数RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(3));
        }
        System.out.println(Double.MAX_VALUE * Double.MAX_VALUE);
    }
}


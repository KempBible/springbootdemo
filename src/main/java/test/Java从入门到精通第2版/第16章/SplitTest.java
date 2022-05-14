package test.Java从入门到精通第2版.第16章;

import java.util.Arrays;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck1f032c402131f0e3dad99f3
public class SplitTest {
    public static void main(String[] args) {
        String str = "192.168.11.2";
        String[] data = str.split("\\.");
        System.out.println(Arrays.toString(data));
    }
}


package test.Java从入门到精通第2版.第16章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck1f032c402131f0e3dad99f3
public class 范例16_11下面通过一个范例来分析字符串替换方法StringReplace {
    public static void main(String[] args) {
        String str = "helloworld"; //字符串
        System.out.println(str.replaceAll("o", "***"));//所有子串出现的位置都替换
        System.out.println(str.replaceFirst("l", "_"));//替换第一次出现字符子串
    }
}

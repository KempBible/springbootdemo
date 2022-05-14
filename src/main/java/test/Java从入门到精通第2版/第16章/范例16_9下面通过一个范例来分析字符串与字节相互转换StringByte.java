package test.Java从入门到精通第2版.第16章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck1f032c402131f0e3dad99f3
public class 范例16_9下面通过一个范例来分析字符串与字节相互转换StringByte {
    public static void main(String[] args) {
        String str = "hellojava"; //直接赋值法建立字符串
        byte[] data = str.getBytes(); // 将字符串变为byte数组
        for (int i = 0; i < data.length; i++) {
            data[i] -= 32;
        }
        System.out.println(new String(data)); //将全部的byte数组变为字符串
        System.out.println(new String(data, 5, 4));
    }
}

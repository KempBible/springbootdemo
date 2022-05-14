package test.Java从入门到精通第2版.第16章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck1f032c402131f0e3dad99f3
public class 范例16_8下面通过一个范例来分析字符串与字符数组互相转换StringArray {
    public static void main(String[] args) {
        String str = "hellojava"; // 直接赋值法
        char[] data = str.toCharArray(); // 将字符串变为字符数组
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "、");
            data[i] -= 32; // 小写变为大写
        }
        System.out.println();
        System.out.println("将全部字符数组变为字符串：" + new String(data));
        //取得部分内容的时候需要设置起始点和取得的长度
        System.out.println("将部分字符数组变为字符串：" + new String(data, 5, 4));
    }
}

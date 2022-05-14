package test.Java从入门到精通第2版.第16章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck1f032c402131f0e3dad99f3
public class 范例16_4分析直接赋值法创建字符串时的内存分配MemmoryAllocation {

    public static void main(String[] args) {
        String strA = "Hello"; //直接赋值法
        String strB = "Hello"; //直接赋值法
        String strC = strB; //引用传递
        System.out.println(strA == strB); //true
        System.out.println(strA == strC); //true
        System.out.println(strB == strC); //true
    }
}

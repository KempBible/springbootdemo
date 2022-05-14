package test.Java从入门到精通第2版.第16章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck1f032c402131f0e3dad99f3
public class 范例16_5分析构造方法创建字符串时的内存分配ConstructorMemmoryAllocation {
    public static void main(String[] args) {
        String strA = "Hello"; //直接赋值
        String strB = new String("Hello").intern(); //手工入池
        String strC = "Hello"; //直接赋值
        String strD = new String("Hello"); //构造法

        System.out.println(strA == strB); //true
        System.out.println(strA == strC); //true
        System.out.println(strB == strC); //true
        System.out.println(strA == strD); //false
    }
}

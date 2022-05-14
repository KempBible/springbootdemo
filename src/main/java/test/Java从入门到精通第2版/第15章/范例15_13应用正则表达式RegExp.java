package test.Java从入门到精通第2版.第15章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec
public class 范例15_13应用正则表达式RegExp {
    public static void main(String[] args) {
        if ("123".matches("\\d")){
            System.out.println("由数字组成1");
        }else {
            System.out.println("不是由数字组成");
        }
    }
}

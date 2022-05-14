package test.Java从入门到精通第2版.第15章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec
public class 范例15_15验证邮箱格式EmailValidation {
    public static void main(String[] args) {
        String str = "kunpeng@163.com";
        String regex = "\\w+@\\w+.\\w+";
        System.out.println(str.matches(regex));
    }
}

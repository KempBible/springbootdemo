package test.Java从入门到精通第2版.第15章;
//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec
public class 范例15_14字符串替换SubString {
    public static void main(String[] args) {
        String str = "1233nnjdfosd888808042cv";

        String regex = "[0-9]+";
        //String regex = "\\d+";
        System.out.println(str.replaceAll(regex, ""));
    }
}

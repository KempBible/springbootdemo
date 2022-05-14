package test.Java从入门到精通第2版.第15章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec
public class 范例15_12判断字符串是否由数字组成JudgeString {
    public static void main(String[] args) {
        if (isNumber("123")){
            System.out.println("由数字组成");
        }else{
            System.out.println("不是由数字组成");
        }
    }

    private static boolean isNumber(String s) {

        char[] data = s.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] < '0' || data[i] > '9'){
                return false;
            }
        }
        return true;
    }
}

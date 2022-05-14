package test.Java从入门到精通第2版.第16章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck1f032c402131f0e3dad99f3
public class 范例16_10下面通过一个范例来分析字符串查找方法StringSearch {
    public static void main(String[] args) {
        String str = "**hello$$world##"; //字符串
        if (str.contains("hello")){ //查找hello是否存在
            System.out.println("内容存在，已查找到");
        }
        if (str.indexOf("r") != -1){ //查找hello是否存在
            System.out.println("内容存在，字符串位置：" + str.indexOf("r"));
        }
        if (str.indexOf("o", 5) != -1){
            System.out.println("内容存在，字符串位置：" + str.indexOf("o"));
        }
        if (str.indexOf("o", 6) != -1){
            System.out.println("内容存在，字符串位置：" + str.indexOf("o"));
        }
        if (str.lastIndexOf("w", 12) != -1){
            System.out.println("内容存在，字符串位置：" + str.lastIndexOf("w", 12));
        }
        System.out.println(str.startsWith("**")); //判断字符串的起始内容
        System.out.println(str.startsWith("$$", 7));
        System.out.println(str.endsWith("##"));
    }
}

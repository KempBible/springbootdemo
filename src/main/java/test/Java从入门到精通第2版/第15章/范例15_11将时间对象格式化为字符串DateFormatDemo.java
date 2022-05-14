package test.Java从入门到精通第2版.第15章;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec
public class 范例15_11将时间对象格式化为字符串DateFormatDemo {
    public static void main(String[] args) {
        //获取当前时间
        LocalDate localDate = LocalDate.now();

        //指定格式化规则
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        //将当前时间格式化
        String str = localDate.format(dateTimeFormatter);
        System.out.println("时间：" + str);
    }
}

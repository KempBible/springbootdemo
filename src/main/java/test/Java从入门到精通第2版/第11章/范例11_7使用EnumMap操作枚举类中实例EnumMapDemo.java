package test.Java从入门到精通第2版.第11章;

import java.util.EnumMap;
import java.util.Map;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53
enum Color1{
    红色, 绿色, 蓝色;
}
public class 范例11_7使用EnumMap操作枚举类中实例EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<Color1, String> enumMap = new EnumMap<Color1, String>(Color1.class);

        enumMap.put(Color1.红色, "RED"); // 添加EnumMap元素

        enumMap.put(Color1.绿色, "GREEN");
        enumMap.put(Color1.蓝色, "BLUE");

        for (Map.Entry<Color1, String> me: enumMap.entrySet()) {
            System.out.println(me.getKey() + "-->" + me.getValue());
        }
        /*
            红色-->RED
            绿色-->GREEN
            蓝色-->BLUE
         */
    }
}


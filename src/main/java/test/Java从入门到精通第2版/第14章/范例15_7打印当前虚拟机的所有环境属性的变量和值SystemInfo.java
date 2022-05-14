package test.Java从入门到精通第2版.第14章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck6f4322302126f4922f45dec

import java.util.Enumeration;
import java.util.Properties;

public class 范例15_7打印当前虚拟机的所有环境属性的变量和值SystemInfo {

    public static void main(String[] args) {
        Properties properties = System.getProperties(); //获得当前虚拟机的环境属性

        Enumeration e = properties.propertyNames(); // 获得环境属性中所有的变量

        // 循环打印出当前虚拟机的所有环境属性的变量和值
        while (e.hasMoreElements()){
            String key = (String) e.nextElement();
            System.out.println(key + "=" + properties.getProperty(key));
        }
    }
}

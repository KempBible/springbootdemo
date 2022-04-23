package test.Java从入门到精通第2版.第11章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53

enum MyColor2{
    红色,绿色,蓝色;
}
public class 范例11_4通过values方法得到对象取值ValueOfEnum {
    public static void main(String[] args) {
        MyColor2[] myColor2 = MyColor2.values();
        for (MyColor2 myColor21:myColor2) {
            System.out.println(myColor21 + " 排序：" + myColor21.ordinal());
            System.out.println(myColor21.name() + " 排序：" + myColor21.ordinal());
        }
    }
}

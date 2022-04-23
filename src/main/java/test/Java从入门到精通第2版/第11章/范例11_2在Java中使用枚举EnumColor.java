package test.Java从入门到精通第2版.第11章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53
enum MyColor{
    红色,绿色,蓝色;
}

public class 范例11_2在Java中使用枚举EnumColor {

    public static void main(String[] args) {
        MyColor myColor1 = MyColor.红色;
        System.out.println(myColor1);

        MyColor myColor2 = MyColor.绿色;
        System.out.println(myColor2);

        MyColor myColor3 = MyColor.蓝色;
        System.out.println(myColor3);
    }
}

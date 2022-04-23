package test.Java从入门到精通第2版.第11章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53
enum MyColor1{
    红色,绿色,蓝色;
}
public class 范例11_3在switch中使用枚举EnumSwitch {
    public static void main(String[] args) {
        MyColor1 myColor1 = MyColor1.红色;

        switch (myColor1){
            case 红色:
                System.out.println(myColor1);
                break;
            case 绿色:
                System.out.println(myColor1);
                break;
            case 蓝色:
                System.out.println(myColor1);
                break;
        }
    }
}

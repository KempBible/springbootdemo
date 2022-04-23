package test.Java从入门到精通第2版.第11章;

// https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53
enum Color{
    红色, 绿色, 蓝色;
}
public class 范例11_6调用Enum类中的valueof方法ValueOfEnum2 {
    public static void main(String[] args) {
        Color color = Color.valueOf(Color.class, "红色");
        System.out.println(color); //红色
    }
}


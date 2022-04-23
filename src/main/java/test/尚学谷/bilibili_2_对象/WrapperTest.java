package test.尚学谷.bilibili_2_对象;

public class WrapperTest {

    public static void main(String[] args) {
        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");
        System.out.println(f1); // 12.3
        System.out.println(f2); // 12.3

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("TrUe");
        System.out.println(b2); // true
        Boolean b3 = new Boolean("true123");
        System.out.println(b3); // false
    }
}

package test.尚学谷;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/2/23 18:52
 */
public class WrapperTest {

    public static void main(String[] args) {
        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");
        System.out.println(f1);
        System.out.println(f2);
        // 声明类型不同
        System.out.println(f1 == f2);

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("TrUe");
        System.out.println(b2);
        Boolean b3 = new Boolean("true123");
        System.out.println(b3);
    }

}
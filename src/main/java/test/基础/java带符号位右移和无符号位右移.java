package test.基础;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 19:40
 */
// https://www.cnblogs.com/gaoquanquan/p/10852808.html
// https://www.cnblogs.com/leo0705/p/8473071.html
/**
 * 结论：
 * 　　>> :
 * 　　　　负数右移用1补位
 * 　　　　正数右移用0补位
 * 　　>>>:
 * 　　　　无论正负，都用0补位
 */
public class java带符号位右移和无符号位右移 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-16));
        System.out.println(Integer.toBinaryString(-16 >> 2));
        System.out.println(-16 >> 2);
        System.out.println();

        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16 >> 2));
        System.out.println(16 >> 2);
        System.out.println();

        System.out.println(Integer.toBinaryString(-16));
        System.out.println(Integer.toBinaryString(-16 >>> 2));
        System.out.println(-16 >>> 2);
        System.out.println();

        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(16 >>> 2));
        System.out.println(16 >>> 2);
        System.out.println();

        System.out.println("0000000000000000000000000000" + Integer.toBinaryString(15));
        // 用补码展示，符号位不变，先转为反码，再讲反码+1
        System.out.println(Integer.toBinaryString(-15));
        System.out.println(-15 >> 2);
        System.out.println(-15 >>> 2);
        System.out.println(15 >> 2);
        System.out.println(15 >>> 2);

        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1 >> 1));
        System.out.println(Integer.toBinaryString(-1 >> 2));
    }

}
package test.尚学谷.bilibili_1_数组;

import java.util.Arrays;

/**
 * java.util.Arrays:操作数组的工具类
 */
public class ArraysTest {

    public static void main(String[] args) {

        // 1.boolean equals(int[] a, int b):判断两个数组是否相等
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        int[] arr3 = new int[]{1,3,2,4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);
        boolean isEquals1 = Arrays.equals(arr2, arr3);
        System.out.println(isEquals1);

        // 2.String toString(int[] a):输出数组信息
        System.out.println(Arrays.toString(arr1));

        // 3.void fill(int[] a, int val)：将指定值填充到数组之中
        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1));

        // 4.void sort(int[] a)：对数组进行顺序
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        // 5.int binarySearch(int[] a, int key)
        int[] arr4 = new int[]{-98, -34, 2, 34, 54, 66, 79, 105, 210, 333};
        Arrays.binarySearch(arr4, 210);
        System.out.println(Arrays.binarySearch(arr4, 210));
    }
}

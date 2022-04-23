package test.尚学谷.bilibili_1_数组;

import java.util.Arrays;

public class YangHuiTest {
    public static void main(String[] args) {
        // 1.声明并初始化二维数组
        int[][] yangHui = new int[10][];

        // 2.给数组的元素赋值
        for (int i = 0; i < yangHui.length; i++) {
            yangHui[i] = new int[i+1];

            // 2.1给首末元素赋值
            yangHui[i][0] = yangHui[i][i] = 1;
            // 2.2给每行的非首末元素赋值
            // if(i > 1){
            for (int j = 1; j < yangHui[i].length - 1; j++) {
                yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
            }
            //}
        }
        for (int[] arr:yangHui) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

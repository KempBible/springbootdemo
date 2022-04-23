package test.Java从入门到精通第2版.第11章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckaab325601eaab3238922e53
public class 范例10_19在方法中对数组进行排序Arraysort {

    public static void sort(int[] arr){
        // 冒泡排序算法
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void printArr(int[] arr, String msg){
        System.out.println(msg);

        for (int i:arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,6,8,4,7};
        printArr(arr, "排序前：");
        sort(arr);
        printArr(arr, "排序后：");
        /*
            排序前：
            3 5 2 6 8 4 7
            排序后：
            8 7 6 5 4 3 2
         */
    }
}

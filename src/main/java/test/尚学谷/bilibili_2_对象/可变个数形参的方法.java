package test.尚学谷.bilibili_2_对象;

public class 可变个数形参的方法 {

    public void show(int i){

    }

    public void show(String s){
        System.out.println("show(String)");
    }

    public void show(String... strs){
        System.out.println("show(String... strs)");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }

    // 不能与上一个方法同时存在
//    public void show(String[] strs){
//
//    }
}

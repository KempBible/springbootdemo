package test.Java从入门到精通第2版.第19章;

import java.util.List;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ckb6d32b90216b6d767d2f0dc
public class 范例19_6关键字throw的使用throwDemo {
    public static void main(String[] args) {
        try {
            throw new ArrayIndexOutOfBoundsException("\n我是个性化的异常信息：\n数组下标越界");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}

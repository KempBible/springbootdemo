package test.尚学谷.bilibili_2_对象;

public class InterviewTest1 {

    public static void main(String[] args) {
        Base1 base1 = new Sub1();
        base1.add(1,2,3);

        Sub1 sub1 = (Sub1)base1;
        sub1.add(1,2,3);
    }
}

class Base1{
    public void add(int a, int... arr){
        System.out.println("base1");
    }
}

class Sub1 extends Base1{
    public void add(int a, int[] arr){
        System.out.println("sub_1");
    }

    public void add(int a, int b, int c){
        System.out.println("sub_2");
    }
}
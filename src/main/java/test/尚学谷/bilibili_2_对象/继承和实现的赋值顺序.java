package test.尚学谷.bilibili_2_对象;

interface A {
    int x = 0;
}

class B {
    int x = 1;
}

public class 继承和实现的赋值顺序 extends B implements A {

    public void pX(){
        System.out.println(new B().x);
        System.out.println(A.x);
    }

    public static void main(String[] args) {
        new 继承和实现的赋值顺序().pX();
    }
}

package test.尚学谷.bilibili_2_对象.内部类;

public class InnerClassTest1 {

    // 开发中很少见
    public void method(){
        // 局部内部类
        class AA{

        }
    }

    // 返回一个实现了Comparable接口的类的对象
    public Comparable getComparable1(){
        // 创建一个实现了Comparable接口的类：局部内部类
        // 方式一：
        class MyComparable implements Comparable{

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new MyComparable();
    }

    // 方式二
    public Comparable getComparable2(){

        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}

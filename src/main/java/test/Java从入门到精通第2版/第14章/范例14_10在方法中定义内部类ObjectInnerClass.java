package test.Java从入门到精通第2版.第14章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck70e32fb021170efdf2eca12
class InnerClassTest{
    int score = 95;
    void inst(){
        class Inner{
            void display(){
                System.out.println("成绩：score=" + score);
            }
        }
        Inner inner = new Inner();
        inner.display();
    }
}

public class 范例14_10在方法中定义内部类ObjectInnerClass {
    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        innerClassTest.inst();
    }
}

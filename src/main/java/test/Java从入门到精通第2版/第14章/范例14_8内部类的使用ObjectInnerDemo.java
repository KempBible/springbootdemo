package test.Java从入门到精通第2版.第14章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck70e32fb021170efdf2eca12
class Outer{
    int score = 95;
    void inst(){
        Inner in = new Inner();
        in.display();
    }

    public class Inner{
        String name = "张三";
        void display(){
            System.out.println(name + " 成绩：score=" + score);
        }
    }
}
public class 范例14_8内部类的使用ObjectInnerDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.inst();
    }
}


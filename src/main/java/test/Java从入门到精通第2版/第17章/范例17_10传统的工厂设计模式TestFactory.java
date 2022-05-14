package test.Java从入门到精通第2版.第17章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck98f3284021498f137082c2e

interface Book2{
    public String getTitle();
}

class MathBook implements Book2{

    @Override
    public String getTitle() {
        return "数学类图书";
    }
}

class Factory{
    public static Book2 getInstance(String className){
        if ("mathbook".equals(className)){
            return new MathBook();
        }
        return null;
    }
}

public class 范例17_10传统的工厂设计模式TestFactory {
    public static void main(String[] args) {
        Book2 book2 = Factory.getInstance("mathbook");
        System.out.println(book2.getTitle());
    }
}
